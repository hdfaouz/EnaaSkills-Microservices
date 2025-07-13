package com.enaa.validation.Controller;

import com.enaa.validation.Service.ValidationService;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ValidationController {

    private  final ValidationService validationService;

    public ValidationController(ValidationService validationService) {
        this.validationService = validationService;
    }
}
