package com.example.validation.Mapper;

import com.example.validation.Dto.ValidationDto;
import com.example.validation.Model.Validation;

import java.util.List;

public interface ValidationMapper {

    Validation toEntity(ValidationDto dto);

    ValidationDto toDto(Validation validation);

    List<ValidationDto> toDtos(List<Validation> validations);
}
