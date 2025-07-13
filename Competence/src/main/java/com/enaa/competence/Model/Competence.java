package com.enaa.competence.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
        private Long id;
        private String titre;
        private boolean statutValidation;

    @OneToMany(mappedBy = "competence", cascade = CascadeType.ALL)
    private List<SousCompetence> sousCompetences;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public boolean isStatutValidation(boolean statutValidation) {
        return this.statutValidation;
    }

    public void setStatutValidation(boolean statutValidation) {
        this.statutValidation = statutValidation;
    }

    public boolean isStatutValidation() {
        return statutValidation;
    }

    public List<SousCompetence> getSousCompetences() {
        return sousCompetences;
    }

    public void setSousCompetences(List<SousCompetence> sousCompetences) {
        this.sousCompetences = sousCompetences;
    }
}
