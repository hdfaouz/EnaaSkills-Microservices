package com.enaa.breif.feignclient;

import com.enaa.breif.dto.Competencedto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "ENAASKills", url = "http://localhost:8080/competence")

public interface Competenceclient {

    @GetMapping
    List<Competencedto> getAll();
}
