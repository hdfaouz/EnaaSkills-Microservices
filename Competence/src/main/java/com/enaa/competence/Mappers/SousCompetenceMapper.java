package com.enaa.competence.Mappers;

import com.enaa.competence.Dto.CompetenceDto;
import com.enaa.competence.Dto.SousCompetenceDto;
import com.enaa.competence.Model.Competence;
import com.enaa.competence.Model.SousCompetence;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SousCompetenceMapper {

    SousCompetence toEntity(SousCompetenceDto dto);

    SousCompetenceDto toDto(SousCompetence competence);

    List<SousCompetenceDto> toDtos(List<SousCompetence> competences);
}
