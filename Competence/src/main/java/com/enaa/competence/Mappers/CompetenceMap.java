package com.enaa.competence.Mappers;

import com.enaa.competence.Dto.CompetenceDto;
import com.enaa.competence.Model.Competence;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompetenceMap {

    Competence toEntity(CompetenceDto dto);

    CompetenceDto toDTO(Competence competence);

    List<CompetenceDto> toDTOs(List<Competence> competences);
}
