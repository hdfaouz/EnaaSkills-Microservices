package com.enaa.competence.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class SousCompetence {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long sousCompetenceId;

   private String sousCompetenceNom;
   private Status sousCompetenceStatus;

    @ManyToOne
    @JoinColumn(name = "competence_id")
    private Competence competence;

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

    public Competence getCompetence() {
        return competence;
    }

    public void setCompetence(Competence competence) {
        this.competence = competence;
    }
}
