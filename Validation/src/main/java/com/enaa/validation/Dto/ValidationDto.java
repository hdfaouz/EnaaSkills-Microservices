package com.enaa.validation.Dto;

public class ValidationDto {

    private Boolean statutValidation;

    public ValidationDto(Boolean statutValidation) {
        this.statutValidation = statutValidation;
    }

    public ValidationDto() {
    }

    public Boolean getStatutValidation() {
        return statutValidation;
    }

    public void setStatutValidation(Boolean statutValidation) {
        this.statutValidation = statutValidation;
    }
}
