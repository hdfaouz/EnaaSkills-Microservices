package com.enaa.apprenant.mappers;

import com.enaa.apprenant.dto.ApprenantDto;
import com.enaa.apprenant.model.Apprenant;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApprenantMap {

    Apprenant toEntity (ApprenantDto apprenantDto);
    ApprenantDto toDto (Apprenant apprenant);
    List<ApprenantDto> toDtos(List<Apprenant> apprenantList);
}
