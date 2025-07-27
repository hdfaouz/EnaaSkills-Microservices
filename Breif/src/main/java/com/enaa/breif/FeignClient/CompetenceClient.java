package com.enaa.breif.FeignClient;

import com.enaa.breif.dto.CompetenceDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "ENAASKills", url = "http://localhost:8080/competence")

public interface CompetenceClient {

    @GetMapping
    List<CompetenceDto> getAll();
}
