package com.enaa.validation.Service;

import com.enaa.validation.Mapper.ValidationMapper;
import com.enaa.validation.Repository.ValidationRepository;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    private final ValidationRepository validationRepository;
    private final ValidationMapper validationMapper;

    public ValidationService(ValidationRepository validationRepository, ValidationMapper validationMapper) {
        this.validationRepository = validationRepository;
        this.validationMapper = validationMapper;
    }



}
