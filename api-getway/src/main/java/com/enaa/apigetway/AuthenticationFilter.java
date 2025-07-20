package com.enaa.apigetway;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.security.Key;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class AuthenticationFilter implements GlobalFilter, Ordered {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${gateway.secret}")
    private String gatewaySecret;

    private final List<String> publicPaths = Arrays.asList(
            "/auth/login",
            "/auth/register",
            "/actuator"
    );
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request =exchange.getRequest();
        String path = request.getPath().toString();

        // Skip authentication for public paths
        if (isPublicPath(path)) {
            return chain.filter(exchange);
        }
        String token = extractToken(request);
        if (token == null) {
            return unauthorized(exchange, "Missing token");
        }
        try {
            Claims claims = validateAndParseClaims(token);

            // Generate a signature to prove the request came from the gateway
            String requestSignature = generateRequestSignature(request, claims);

            // Add user information to headers for downstream services
            ServerHttpRequest modifiedRequest = request.mutate()
                    .header("X-User-Id", claims.getSubject())
                    .header("X-User-Roles", String.join(",", getRoles(claims)))
                    .header("X-User-Email", claims.get("email", String.class))
                    .header("X-Gateway-Secret", gatewaySecret) // Trust header
                    .build();

            return chain.filter(exchange.mutate().request(modifiedRequest).build());

        } catch (Exception e) {
            return unauthorized(exchange, "Invalid token: " + e.getMessage());
        }

    }
    private String generateRequestSignature(ServerHttpRequest request, Claims claims) {
        String dataToSign = claims.getSubject() + "|" + request.getPath() + "|" + System.currentTimeMillis();
        return HmacUtils.hmacSha256Hex(gatewaySecret, dataToSign);
    }
    private boolean isPublicPath(String path) {
        return publicPaths.stream().anyMatch(path::contains);
    }
    private String extractToken(ServerHttpRequest request) {
        String header = request.getHeaders().getFirst("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7);
        }
        return null;
    }


    private Claims validateAndParseClaims(String token) {
        byte[] keyBytes = jwtSecret.getBytes();
        Key key = Keys.hmacShaKeyFor(keyBytes);

        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    @SuppressWarnings("unchecked")
    private List<String> getRoles(Claims claims) {
        List<String> roles = claims.get("roles", List.class);
        return roles != null ? roles : Collections.emptyList();
    }

    private Mono<Void> unauthorized(ServerWebExchange exchange, String message) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.UNAUTHORIZED);

        DataBuffer buffer = response.bufferFactory().wrap(
                ("{\"error\": \"" + message + "\"}").getBytes()
        );

        return response.writeWith(Mono.just(buffer));
    }
    @Override
    public int getOrder() {
        return -100;
    }
}
