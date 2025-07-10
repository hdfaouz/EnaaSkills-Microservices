package com.enaa.competence.Dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class CompetenceDto {

    private String titre;
    private boolean statutValidation;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public boolean isStatutValidation() {
        return statutValidation;
    }

    public void setStatutValidation(boolean statutValidation) {
        this.statutValidation = statutValidation;
    }
}
