package com.enaa.rendu.Service;


import com.enaa.rendu.Dto.RenduDto;
import com.enaa.rendu.Feign.ApprenantClient;
import com.enaa.rendu.Feign.BreifClient;
import com.enaa.rendu.Mappers.RenduMap;
import com.enaa.rendu.Model.Rendu;
import com.enaa.rendu.Repository.RenduRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RenduService {

    @Autowired
    private ApprenantClient apprenantClient;

    @Autowired
    private RenduRepository renduRepository;

    @Autowired
    private RenduMap renduMap;

    @Autowired
    private BreifClient breifClient;


    public RenduDto ajouterRendu(RenduDto renduDto) {
       return renduMap.toDto(renduRepository.save(renduMap.toEntity(renduDto)));
    }

    public List<RenduDto> getAllRendu(){
        List<Rendu> rendus = renduRepository.findAll();
        return renduMap.toDtos(rendus);
    }

    public void deleteRendu(Long id){
        renduRepository.deleteById(id);
    }

    public List<Long> getRenduIdsByBriefId(Long id){
        return renduRepository.findIds(id);
    }




}
