package com.enaa.validation.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Validation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long validationId;

    private Boolean statutValidation;

    public Validation(Long validationId, Boolean statutValidation) {
        this.validationId = validationId;
        this.statutValidation = statutValidation;
    }

    public Validation() {
    }

    public Long getValidationId() {
        return validationId;
    }

    public void setValidationId(Long validationId) {
        this.validationId = validationId;
    }

    public Boolean getStatutValidation() {
        return statutValidation;
    }

    public void setStatutValidation(Boolean statutValidation) {
        this.statutValidation = statutValidation;
    }
}
