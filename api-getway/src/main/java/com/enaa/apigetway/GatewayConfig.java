package com.enaa.apigetway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("auth-service", r -> r
                        .path("/auth/**")
                        .uri("lb://auth-service"))
                .route("apprenant-service", r -> r
                        .path("/api/apprenant/**")
                        .uri("lb://apprenant-service"))
                .route("rendu-service", r -> r
                        .path("/api/rendu/**")
                        .uri("lb://rendu-service"))
                .route("validation-service", r -> r
                        .path("/api/validation/**")
                        .uri("lb://validation-service"))
                .build();
    }
}
