package com.enaa.competence.Dto;

import com.enaa.competence.Model.Status;

public class SousCompetenceDto {


    private String sousCompetenceNom;
    private Status sousCompetenceStatus;

    public SousCompetenceDto(String sousCompetenceNom, Status sousCompetenceStatus) {
        this.sousCompetenceNom = sousCompetenceNom;
        this.sousCompetenceStatus = sousCompetenceStatus;
    }

    public SousCompetenceDto() {
    }

    public String getSousCompetenceNom() {
        return sousCompetenceNom;
    }

    public void setSousCompetenceNom(String sousCompetenceNom) {
        this.sousCompetenceNom = sousCompetenceNom;
    }

    public Status getSousCompetenceStatus() {
        return sousCompetenceStatus;
    }

    public void setSousCompetenceStatus(Status sousCompetenceStatus) {
        this.sousCompetenceStatus = sousCompetenceStatus;
    }
}
