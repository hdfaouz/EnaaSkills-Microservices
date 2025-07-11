package com.enaa.competence.Mappers;

import com.enaa.competence.Dto.CompetenceDto;
import com.enaa.competence.Model.Competence;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SousCompetenceMapper {

    Competence toEntity(CompetenceDto dto);

    CompetenceDto toDto(Competence competence);

    List<CompetenceDto> toDtod(List<Competence> competences);
}
