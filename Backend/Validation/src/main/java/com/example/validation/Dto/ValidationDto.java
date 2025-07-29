package com.example.validation.Dto;

public class ValidationDto {

    private Boolean validationStatus;
    private Long renduId;
    private Long competenceId;
    private Long briefId;
    private Long apprenantId;
    private String commentaire;

    public ValidationDto(Boolean validationStatus, Long renduId, Long competenceId, Long briefId, Long apprenantId, String commentaire) {
        this.validationStatus = validationStatus;
        this.renduId = renduId;
        this.competenceId = competenceId;
        this.briefId = briefId;
        this.apprenantId = apprenantId;
        this.commentaire = commentaire;
    }

    public ValidationDto() {
    }

    public Boolean getValidationStatus() {
        return validationStatus;
    }

    public void setValidationStatus(Boolean validationStatus) {
        this.validationStatus = validationStatus;
    }

    public Long getRenduId() {
        return renduId;
    }

    public void setRenduId(Long renduId) {
        this.renduId = renduId;
    }

    public Long getCompetenceId() {
        return competenceId;
    }

    public void setCompetenceId(Long competenceId) {
        this.competenceId = competenceId;
    }

    public Long getBriefId() {
        return briefId;
    }

    public void setBriefId(Long briefId) {
        this.briefId = briefId;
    }

    public Long getApprenantId() {
        return apprenantId;
    }

    public void setApprenantId(Long apprenantId) {
        this.apprenantId = apprenantId;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}
