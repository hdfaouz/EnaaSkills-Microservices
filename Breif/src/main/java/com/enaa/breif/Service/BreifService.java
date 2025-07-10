package com.enaa.breif.Service;

import com.enaa.breif.Dto.BreifDto;
import com.enaa.breif.Mappers.BreifMap;
import com.enaa.breif.Model.Breif;
import com.enaa.breif.Repository.BreifRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreifService {

    private final BreifRepository breifRepository;
    private final BreifMap breifMap;

    public BreifService(BreifRepository breifRepository, BreifMap breifMap) {
        this.breifRepository = breifRepository;
        this.breifMap = breifMap;
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





}
