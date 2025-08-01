package com.enaa.breif.Service;

import com.enaa.breif.Dto.BreifDto;
import com.enaa.breif.Dto.Competencedto;
import com.enaa.breif.FeignClient.CompetenceClient;
import com.enaa.breif.FeignClient.RenduClient;
import com.enaa.breif.Mappers.BreifMap;
import com.enaa.breif.Model.Breif;
import com.enaa.breif.Repository.BreifRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreifService {

    private final BreifRepository breifRepository;
    private final BreifMap breifMap;
    private final CompetenceClient competenceClient;
    private final RenduClient renduClient;

    public BreifService(BreifRepository breifRepository, BreifMap breifMap, CompetenceClient competenceClient, RenduClient renduClient) {
        this.breifRepository = breifRepository;
        this.breifMap = breifMap;
        this.competenceClient = competenceClient;
        this.renduClient = renduClient;
    }

    public BreifDto ajouterBreif(BreifDto breifDto){
        Breif breif = breifMap.toEntity(breifDto);
        Breif saveBreif = breifRepository.save(breif);
        return breifMap.toDto(saveBreif);
    }

    public List<BreifDto> getAllBreifs(){
         List<Breif> breifs = breifRepository.findAll();
        return breifMap.toDtos(breifs);
    }

    public BreifDto updat(long id, BreifDto breifDto){
        Breif breif = breifRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Breif not found"));

        breif.setTitre(breifDto.getTitre());
        breif.setDateDepart(breifDto.getDateDepart());
        breif.setDateFin(breifDto.getDateFin());

        Breif savedBreif = breifRepository.save(breif);

        return breifMap.toDto(savedBreif);
    }

    public void delete(Long id){
        breifRepository.deleteById(id);
    }

    public BreifDto getBreifById(Long id){
        Breif foundBreif =breifRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Breif not found"));
        return breifMap.toDto(foundBreif);
    }

    public List<Competencedto> getAllCompetence(){
        return competenceClient.getAll();
    }

    public Breif getByRenduIds(Long id){
        Breif breif = breifRepository.findById(id).orElseThrow();
        List<Long> rendus = renduClient.getRenduIdsByBriefId(id);
        breif.setRendus(rendus);
        return breif;
    }





}
