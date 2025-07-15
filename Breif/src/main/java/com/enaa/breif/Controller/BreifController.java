package com.enaa.breif.Controller;

import com.enaa.breif.Dto.BreifDto;
import com.enaa.breif.Dto.CompetenceDto;
import com.enaa.breif.FeignClient.RenduClient;
import com.enaa.breif.Model.Breif;
import com.enaa.breif.Repository.BreifRepository;
import com.enaa.breif.Service.BreifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/breif")
public class BreifController {

    private final BreifService breifService;
    private  final BreifRepository breifRepository;

    public BreifController(BreifService breifService , BreifRepository breifRepository) {
        this.breifService = breifService;
        this.breifRepository = breifRepository;
    }

    @Autowired
    RenduClient renduClient;


    @GetMapping("/briefid/idsrendu")
    public Breif getRendusByBreifIds(Long id){
        Breif breif = breifRepository.findById(id).orElseThrow(null);
        List<Long> rendus = renduClient.getRenduIdsByBriefId(id);
        breif.setRendus(rendus);
        return breif;
    }

    @PostMapping
    public BreifDto ajouterBreif(@RequestBody BreifDto breifDto){
        return breifService.ajouterBreif(breifDto);
    }
    @GetMapping
    public List<BreifDto> getAll(){
        return breifService.getAllBreifs();
    }
    @PutMapping("/{id}")
    public BreifDto update(@PathVariable Long id, @RequestBody BreifDto breifDto){
        return breifService.updat(id,breifDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        breifService.delete(id);
    }

    @GetMapping("/getById/{id}")
    public BreifDto getById(@PathVariable Long id){
        return breifService.getBreifById(id);
    }

    @GetMapping("/competence")
    public List<CompetenceDto> getAllComp(){
        return breifService.getAllCompetence();
    }
}
