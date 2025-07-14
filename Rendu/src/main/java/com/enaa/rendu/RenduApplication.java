package com.enaa.rendu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients(basePackages = "com.enaa.rendu.Feign") // adapter si besoin

public class RenduApplication {

    public static void main(String[] args) {
        SpringApplication.run(RenduApplication.class, args);
    }

}
