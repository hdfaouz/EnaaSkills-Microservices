package com.enaa.rendu.Service;

import com.enaa.apprenant.Dto.ApprenantDto;
import com.enaa.apprenant.Model.Apprenant;
import com.enaa.breif.Dto.BreifDto;
import com.enaa.rendu.Dto.RenduDto;
import com.enaa.rendu.Feign.ApprenantClient;
import com.enaa.rendu.Feign.BreifClient;
import com.enaa.rendu.Mappers.RenduMap;
import com.enaa.rendu.Model.Rendu;
import com.enaa.rendu.Repository.RenduRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class RenduService {

    private  ApprenantClient apprenantClient;

    private RenduRepository renduRepository;

    private  RenduMap renduMap;

    private BreifClient breifClient;

    public RenduDto ajouterRendu(RenduDto renduDto, Long idApprenant, Long idBreif) {
        // Vérifier que l'apprenant existe
        ApprenantDto apprenant = apprenantClient.getApprenantById(idApprenant);
        if (apprenant == null) {
            throw new RuntimeException("Apprenant not found");
        }

        // Vérifier que le brief existe
        BreifDto brief = breifClient.getBriefById(idBreif);
        if (brief == null) {
            throw new RuntimeException("Brief not found");
        }

        Rendu rendu = renduMap.toEntity(renduDto);
        Rendu savedRendu = renduRepository.save(rendu);
        return renduMap.toDto(savedRendu);
    }



}
