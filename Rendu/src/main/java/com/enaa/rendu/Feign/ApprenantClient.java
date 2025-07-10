package com.enaa.rendu.Feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "apprenant", url = "${apprenant.service.url}")
public interface ApprenantClient {
}
