package com.enaa.rendu.Dto;

import java.io.Serializable;
import java.util.Date;

public class BreifDto implements Serializable {
    private Long idBreif;
    private String titre;
    private Date dateDepart;
    private Date dateFin;

    public BreifDto(Long idBreif, String titre, Date dateDepart, Date dateFin) {
        this.idBreif = idBreif;
        this.titre = titre;
        this.dateDepart = dateDepart;
        this.dateFin = dateFin;
    }

    public BreifDto() {
    }

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
