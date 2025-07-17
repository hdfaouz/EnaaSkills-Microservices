package com.enaa.apprenant.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "Rendu" , url = "http://localhost:8083/rendAp/{idApprenant}")
public interface RenduClient {

    @GetMapping()
     Long getRenduByIdApprenent(@PathVariable ("idApprenant")Long idApprenant);




}
