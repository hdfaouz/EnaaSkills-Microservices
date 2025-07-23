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
//@RequestMapping("/breif")
public class BreifController {

    private final BreifService breifService;

    public BreifController(BreifService breifService) {
        this.breifService = breifService;

    }


    @GetMapping("/{id}/idsrendu")
    public Breif getRendusByBreifIds(@PathVariable Long id){

        return breifService.getByRenduIds(id);
    }

    @PostMapping("/add")
    public BreifDto ajouterBreif(@RequestBody BreifDto breifDto){
        return breifService.ajouterBreif(breifDto);
    }


    @GetMapping("/all")
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
