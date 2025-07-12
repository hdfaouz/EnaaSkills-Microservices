package com.enaa.competence.Controller;


import com.enaa.competence.Dto.SousCompetenceDto;
import com.enaa.competence.Service.SousCompetenceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sousCompetence")
public class SousCompetenceController {

    public final SousCompetenceService sousCompetenceService;

    public SousCompetenceController(SousCompetenceService sousCompetenceService) {
        this.sousCompetenceService = sousCompetenceService;
    }

    @PostMapping
    public SousCompetenceDto createSousCompetence(@RequestBody SousCompetenceDto dto){
        return sousCompetenceService.ajouter(dto);
    }

    @GetMapping("/all")
    public List<SousCompetenceDto> getSousCompetences(){
        return sousCompetenceService.getAll();
    }

    @DeleteMapping("/{sousCompetenceId}")
    public void deleteSousCompetence(@PathVariable Long sousCompetenceId){
        sousCompetenceService.delete(sousCompetenceId);
    }

    @PutMapping("/{sousCompetenceId}")
    public  SousCompetenceDto updateSousCompetence(@PathVariable Long sousCompetenceId,@RequestBody SousCompetenceDto dto){
        return sousCompetenceService.update(dto,sousCompetenceId);
    }
}
