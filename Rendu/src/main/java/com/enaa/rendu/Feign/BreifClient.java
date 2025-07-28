package com.enaa.rendu.Feign;
import com.enaa.rendu.Dto.BreifDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "Breif", url = "http://localhost:8082")
public interface BreifClient {
    @PostMapping("/brief")
    BreifDto ajouterBrief(@RequestBody BreifDto breifDto);
    @GetMapping
     List<BreifDto> getAllBreifs();
    @PutMapping("/brief/{id}")
    BreifDto updateBrief(@PathVariable Long id, @RequestBody BreifDto breifDto) ;
    @DeleteMapping("/brief{id}")
    void deleteBrief(@PathVariable Long id) ;

    @GetMapping("/brief/{id}")
    BreifDto getBriefById(@PathVariable Long id);

}
