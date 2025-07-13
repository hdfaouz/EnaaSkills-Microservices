package com.enaa.competence.Service;

import com.enaa.competence.Dto.SousCompetenceDto;
import com.enaa.competence.Mappers.SousCompetenceMapper;
import com.enaa.competence.Model.SousCompetence;
import com.enaa.competence.Repository.SousComptenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SousCompetenceService {

    private final SousComptenceRepository sousComptenceRepository;
    private final SousCompetenceMapper sousCompetenceMapper;

    public SousCompetenceService(SousComptenceRepository sousComptenceRepository, SousCompetenceMapper sousCompetenceMapper) {
        this.sousComptenceRepository = sousComptenceRepository;
        this.sousCompetenceMapper = sousCompetenceMapper;
    }

    public SousCompetenceDto ajouter(SousCompetenceDto dto){
        SousCompetence sousCompetence =sousCompetenceMapper.toEntity(dto);
        SousCompetence saved = sousComptenceRepository.save(sousCompetence);

        return sousCompetenceMapper.toDto(saved);
    }

    public void delete(Long sousCompetenceId){sousComptenceRepository.deleteById(sousCompetenceId);}

    public SousCompetenceDto update(SousCompetenceDto dto,Long sousCompetenceId){
        SousCompetence sousCompetence =sousComptenceRepository.findById(sousCompetenceId).orElseThrow(()->new RuntimeException("not found"));
        sousCompetence.setSousCompetenceNom(dto.getSousCompetenceNom());
        sousCompetence.setSousCompetenceStatus(dto.getSousCompetenceStatus());
        SousCompetence saved = sousComptenceRepository.save(sousCompetence);


        return sousCompetenceMapper.toDto(saved);

    }

    public List<SousCompetenceDto> getAll(){
        List<SousCompetence> sousCompetences = sousComptenceRepository.findAll();
        return sousCompetenceMapper.toDtos(sousCompetences);
    }

}
