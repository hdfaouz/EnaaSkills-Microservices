package com.enaa.validation.Mapper;

import com.enaa.validation.Dto.ValidationDto;
import com.enaa.validation.Model.Validation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ValidationMapper {

Validation toEntity(ValidationDto dto);

ValidationDto toDto(Validation validation);

List<ValidationDto> toDtos(List<Validation> validations);
}
