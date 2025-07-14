package com.enaa.rendu.Service;

import com.enaa.apprenant.Dto.ApprenantDto;
import com.enaa.breif.Dto.BreifDto;
import com.enaa.rendu.Dto.RenduDto;
import com.enaa.rendu.Feign.ApprenantClient;
import com.enaa.rendu.Feign.BreifClient;
import com.enaa.rendu.Mappers.RenduMap;
import com.enaa.rendu.Model.Rendu;
import com.enaa.rendu.Repository.RenduRepository;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RenduService {

    private final ApprenantClient apprenantClient;

    private final RenduRepository renduRepository;

    private final   RenduMap renduMap;

    private BreifClient breifClient;
    public RenduDto save(RenduDto renduDTO) {
        try {
            ApprenantDto apprenant = apprenantClient.getApprenantById(renduDTO.getIdApprenant());
        } catch (FeignException.NotFound e) {
            throw new RuntimeException("Apprenant non trouvé avec l'ID : " + renduDTO.getIdApprenant());
        }

//        try {
//            CompetenceDto competenceDto = competenceClient.getCompetenceById(renduDTO.getIdCompetence());
//        } catch (FeignException.NotFound e) {
//            throw new RuntimeException("competence non trouvé avec l'ID : " + renduDTO.getIdCompetence());
//        }


        Rendu rendu = renduMap.toEntity(renduDTO);
        rendu.setIdApprenant(renduDTO.getIdApprenant());

//        rendu.setIdCompetence(renduDTO.getIdCompetence());

        return renduMap.toDto(renduRepository.save(rendu));
    }
    public List<RenduDto> getAllRendu(){
        List<Rendu> rendus = renduRepository.findAll();
        return renduMap.toDtos(rendus);
    }

    public void deleteRendu(Long id){
        renduRepository.deleteById(id);
    }



}
