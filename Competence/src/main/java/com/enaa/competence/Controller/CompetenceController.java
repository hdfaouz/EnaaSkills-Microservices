package com.enaa.competence.Controller;

import com.enaa.competence.Dto.CompetenceDto;
import com.enaa.competence.Service.CompetenceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
