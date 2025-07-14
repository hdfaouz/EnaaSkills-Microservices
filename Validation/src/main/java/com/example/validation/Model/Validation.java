package com.example.validation.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Validation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long validationId;

    private Boolean validationStatus;
    private Long renduId;
    private Long competenceId;
    private Long briefId;
    private Long apprenantId;
    private String commentaire;

    public Validation(Long validationId, Boolean validationStatus, Long renduId, Long competenceId, Long briefId, Long apprenantId, String commentaire) {
        this.validationId = validationId;
        this.validationStatus = validationStatus;
        this.renduId = renduId;
        this.competenceId = competenceId;
        this.briefId = briefId;
        this.apprenantId = apprenantId;
        this.commentaire = commentaire;
    }

    public Validation() {
    }

    public Long getValidationId() {
        return validationId;
    }

    public void setValidationId(Long validationId) {
        this.validationId = validationId;
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
