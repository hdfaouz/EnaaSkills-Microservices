package com.enaa.rendu.Feign;

import com.enaa.apprenant.Dto.ApprenantDto;
import com.enaa.breif.Dto.BreifDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "breif", url = "http://localhost:8082")
public interface BreifClient {
    @GetMapping("/getById/{id}")
    BreifDto getBriefById(@PathVariable("id") Long idBreif);

    @GetMapping("/brief")
    List<BreifDto> getAllBriefs();

}
