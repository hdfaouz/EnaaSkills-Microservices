package com.enaa.breif.Service;

import com.enaa.breif.Dto.BreifDto;
import com.enaa.breif.Mappers.BreifMap;
import com.enaa.breif.Model.Breif;
import com.enaa.breif.Repository.BreifRepository;
import org.springframework.stereotype.Service;

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
}
