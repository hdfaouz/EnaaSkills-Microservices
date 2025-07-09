package com.enaa.apprenant.Mappers;

import com.enaa.apprenant.Dto.ApprenantDto;
import com.enaa.apprenant.Model.Apprenant;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApprenantMap {

    Apprenant toEntity (ApprenantDto apprenantDto);
    ApprenantDto toDto (Apprenant apprenant);
    List<ApprenantDto> toDtos(List<Apprenant> apprenantList);
}
