package com.enaa.rendu.Feign;
import com.enaa.rendu.dto.Breifdto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "Breif", url = "http://localhost:8082")
public interface BreifClient {
    @PostMapping("/brief")
    Breifdto ajouterBrief(@RequestBody Breifdto breifDto);
    @GetMapping
     List<Breifdto> getAllBreifs();
    @PutMapping("/brief/{id}")
    Breifdto updateBrief(@PathVariable Long id, @RequestBody Breifdto breifDto) ;
    @DeleteMapping("/brief{id}")
    void deleteBrief(@PathVariable Long id) ;

    @GetMapping("/brief/{id}")
    Breifdto getBriefById(@PathVariable Long id);

}
