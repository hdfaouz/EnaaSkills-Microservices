package com.enaa.rendu.Feign;

import com.enaa.rendu.dto.Apprenantdto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "Apprenant", url = "http://localhost:8081")
public interface ApprenantClient {

    @PostMapping("/apprenant")
    Apprenantdto create(@RequestBody Apprenantdto dto) ;

    @GetMapping
     List<Apprenantdto> getAll();

    @GetMapping("/apprenant/getById/{id}")
    Apprenantdto getApprenantById(@PathVariable Long id) ;

    @PutMapping("/apprenants/{id}")
    Apprenantdto update(@PathVariable Long id, @RequestBody Apprenantdto dto) ;
}
