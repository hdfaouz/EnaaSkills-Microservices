package com.enaa.rendu.Feign;

import com.enaa.apprenant.Dto.ApprenantDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "Apprenant", url = "http://localhost:8081")
public interface ApprenantClient {

    @GetMapping("/getById/{id}")
    ApprenantDto getApprenantById(@PathVariable("id") Long idApprenant);

    @GetMapping("/apprenant")
    List<ApprenantDto> getAllApprenants();
}
