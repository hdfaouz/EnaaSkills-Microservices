package com.enaa.breif.Mappers;

import com.enaa.breif.dto.BreifDto;
import com.enaa.breif.Model.Breif;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BreifMap {

    Breif toEntity (BreifDto breifDto);

    BreifDto toDto (Breif breif);

    List<BreifDto> toDtos (List<Breif> breif);
}
