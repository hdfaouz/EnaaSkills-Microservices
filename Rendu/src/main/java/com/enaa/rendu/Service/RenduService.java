package com.enaa.rendu.Service;

import com.enaa.rendu.Dto.ApprenantDto;
import com.enaa.rendu.Dto.BreifDto;
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
        System.out.println("=== ajouterRendu method called ===");
        System.out.println("ApprenantClient in method: " + (apprenantClient == null ? "NULL" : "Available"));

        if (apprenantClient == null) {
            throw new RuntimeException("ApprenantClient is null!");
        }

        // Vérifier que l'apprenant existe
        ApprenantDto apprenant = apprenantClient.getApprenantById(renduDto.getIdApprenant());
        if (apprenant == null) {
            throw new RuntimeException("Apprenant not found");
        }

        // Vérifier que le brief existe
        BreifDto brief = breifClient.getBriefById(renduDto.getIdBreif());
        if (brief == null) {
            throw new RuntimeException("Brief not found");
        }

        Rendu rendu = renduMap.toEntity(renduDto);
        rendu.setIdApprenant(renduDto.getIdApprenant());
        rendu.setIdBreif(brief.getIdBreif());
        Rendu savedRendu = renduRepository.save(rendu);
        return renduMap.toDto(savedRendu);
    }

    public List<RenduDto> getAllRendu(){
        List<Rendu> rendus = renduRepository.findAll();
        return renduMap.toDtos(rendus);
    }

    public void deleteRendu(Long id){
        renduRepository.deleteById(id);
    }



}
