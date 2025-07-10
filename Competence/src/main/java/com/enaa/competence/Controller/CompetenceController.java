package com.enaa.competence.Controller;

import com.enaa.competence.Dto.CompetenceDto;
import com.enaa.competence.Model.Competence;
import com.enaa.competence.Service.CompetenceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/competence")
public class CompetenceController {

    private final CompetenceService competenceService;

    public CompetenceController(CompetenceService competenceService) {
        this.competenceService = competenceService;
    }

    @PostMapping
    public CompetenceDto ajouterCompetence(@RequestBody CompetenceDto competenceDto){
        return competenceService.ajouterCompetence(competenceDto);
    }

    @GetMapping
    public List<CompetenceDto> getAllCompetences(){
        return competenceService.getAllCompetences();
    }
}
