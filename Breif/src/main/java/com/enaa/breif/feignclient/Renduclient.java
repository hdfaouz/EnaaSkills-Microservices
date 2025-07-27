package com.enaa.breif.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "Rendu" , url = "http://localhost:8083/rendu/brief")

public interface Renduclient {

    @GetMapping("/{briefid}")
    List<Long> getRenduIdsByBriefId(@PathVariable("briefid") Long briefid);
}
