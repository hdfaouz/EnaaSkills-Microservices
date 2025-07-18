package com.example.validation.Client;

import com.example.validation.Dto.BriefDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "",url = "")
public interface BriefClient {

    @GetMapping("/briefs/{idbrief}")
    BriefDto getBriefById(@PathVariable("idbrief")Long id);
}
