package com.enaa.breif.Dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.function.LongToIntFunction;

@NoArgsConstructor
@AllArgsConstructor
public class BreifDto {

    private Long idBreif;

    private String titre;
    private Date dateDepart;
    private Date dateFin;

    public Long getIdBreif() {
        return idBreif;
    }

    public void setIdBreif(Long idBreif) {
        this.idBreif = idBreif;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
}
