package com.example.validation.Service;

import com.example.validation.Mapper.ValidationMapper;
import com.example.validation.Repository.ValidationRepository;
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
