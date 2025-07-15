package com.enaa.rendu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.enaa.rendu")
@EnableFeignClients(basePackages = "com.enaa.rendu.Feign")
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class RenduApplication {

    public static void main(String[] args) {
        SpringApplication.run(RenduApplication.class, args);
    }

}
