package com.enaa.competence.Service;

import com.enaa.competence.Dto.CompetenceDto;
import com.enaa.competence.Mappers.CompetenceMap;
import com.enaa.competence.Model.Competence;
import com.enaa.competence.Repository.CompetenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetenceService {

    private final CompetenceMap competenceMap;
    private final CompetenceRepository competenceRepository;

    public CompetenceService(CompetenceMap competenceMap, CompetenceRepository competenceRepository) {
        this.competenceMap = competenceMap;
        this.competenceRepository = competenceRepository;
    }

    public CompetenceDto ajouterCompetence(CompetenceDto competenceDto){
        Competence competence = competenceMap.toEntity(competenceDto);
        Competence saveCompetence = competenceRepository.save(competence);
        return competenceMap.toDTO(saveCompetence);
    }

    public List<CompetenceDto> getAllCompetences(){
        List<Competence> competences = competenceRepository.findAll();
       return competenceMap.toDTOs(competences);
    }
}
