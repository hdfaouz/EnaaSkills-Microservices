package com.enaa.rendu.Feign;

import com.enaa.rendu.Dto.ApprenantDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "Apprenant", url = "http://localhost:8081")
public interface ApprenantClient {

    @PostMapping("/apprenant")
    ApprenantDto create(@RequestBody ApprenantDto dto) ;

    @GetMapping
     List<ApprenantDto> getAll();

    @GetMapping("/apprenant/getById/{id}")
    ApprenantDto getApprenantById(@PathVariable Long id) ;

    @PutMapping("/apprenants/{id}")
    ApprenantDto update(@PathVariable Long id, @RequestBody ApprenantDto dto) ;
}
