package com.enaa.apprenant.Service;

import com.enaa.apprenant.Dto.ApprenantDto;
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

    public ApprenantService(ApprenantMap apprenantMap, ApprenantRepository apprenantRepository) {
        this.apprenantMap = apprenantMap;
        this.apprenantRepository = apprenantRepository;
    }

    public ApprenantDto ajouterApprenant(ApprenantDto apprenantDto){
        Apprenant apprenant = apprenantMap.toEntity(apprenantDto);
        Apprenant saveApprenant = apprenantRepository.save(apprenant);
        return apprenantMap.toDto(saveApprenant);
    }

    public List<ApprenantDto> getAll(){
        List<Apprenant> apprenants = apprenantRepository.findAll();
        return apprenantMap.toDtos(apprenants);
    }



}
