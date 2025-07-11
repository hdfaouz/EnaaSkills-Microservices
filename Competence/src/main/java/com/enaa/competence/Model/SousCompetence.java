package com.enaa.competence.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SousCompetence {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long sousCompetenceId;

   private String sousCompetenceNom;
   private Status sousCompetenceStatus;

    public SousCompetence(Long sousCompetenceId, String sousCompetenceNom, Status sousCompetenceStatus) {
        this.sousCompetenceId = sousCompetenceId;
        this.sousCompetenceNom = sousCompetenceNom;
        this.sousCompetenceStatus = sousCompetenceStatus;
    }

    public SousCompetence() {
    }

    public Long getSousCompetenceId() {
        return sousCompetenceId;
    }

    public void setSousCompetenceId(Long sousCompetenceId) {
        this.sousCompetenceId = sousCompetenceId;
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
