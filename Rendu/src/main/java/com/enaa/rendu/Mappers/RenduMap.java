package com.enaa.rendu.Mappers;

import com.enaa.apprenant.Dto.ApprenantDto;
import com.enaa.apprenant.Model.Apprenant;
import com.enaa.rendu.Dto.RenduDto;
import com.enaa.rendu.Model.Rendu;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RenduMap {

    Rendu toEntity (RenduDto renduDto);
    RenduDto toDto (Rendu rendu);
    List<RenduDto> toDtos(List<Rendu> renduList);

}
