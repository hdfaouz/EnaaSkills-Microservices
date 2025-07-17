package com.enaa.apprenant.Service;

import com.enaa.apprenant.Dto.ApprenantDto;
import com.enaa.apprenant.FeignClient.RenduClient;
import com.enaa.apprenant.Mappers.ApprenantMap;
import com.enaa.apprenant.Model.Apprenant;
import com.enaa.apprenant.Repositories.ApprenantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprenantService {

    private final ApprenantMap apprenantMap;
    private final ApprenantRepository apprenantRepository;
    private  final RenduClient renduClient;

    public ApprenantService(ApprenantMap apprenantMap, ApprenantRepository apprenantRepository, RenduClient renduClient) {
        this.apprenantMap = apprenantMap;
        this.apprenantRepository = apprenantRepository;
        this.renduClient = renduClient;
    }

    public ApprenantDto ajouterApprenant(ApprenantDto apprenantDto){
        Apprenant apprenant = apprenantMap.toEntity(apprenantDto);
        Apprenant saveApprenant = apprenantRepository.save(apprenant);
        return apprenantMap.toDto(saveApprenant);
    }

    public List<ApprenantDto> getAllApprenants(){
        List<Apprenant> apprenants = apprenantRepository.findAll();
        return apprenantMap.toDtos(apprenants);
    }

    public ApprenantDto update(Long id, ApprenantDto apprenantDto){
        Apprenant apprenant = apprenantRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("apprenant not found"));

        apprenant.setNom(apprenantDto.getNom());
        apprenant.setPrenom(apprenantDto.getPrenom());
        apprenant.setEmail(apprenantDto.getEmail());


        Apprenant savedApprenant = apprenantRepository.save(apprenant);

        return apprenantMap.toDto(savedApprenant);
    }

    public void delete(Long id){
        apprenantRepository.deleteById(id);
    }
    public ApprenantDto getApprenantById(Long id){
        Apprenant foundApprenant =apprenantRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("apprenant not found"));
        return apprenantMap.toDto(foundApprenant);
    }

    public Long getRenduByIdApprenent(Long idApprenant){
        return renduClient.getRenduByIdApprenent(idApprenant);
    }



}
