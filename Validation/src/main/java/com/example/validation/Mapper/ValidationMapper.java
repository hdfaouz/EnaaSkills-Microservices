package com.example.validation.Mapper;

import com.example.validation.Dto.ValidationDto;
import com.example.validation.Model.Validation;
import com.example.validation.ValidationApplication;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ValidationMapper {

Validation toEntity(ValidationDto dto);

ValidationDto toDto(Validation validation);

List<ValidationDto> toDos(List<Validation> validations);
}
