package com.example.validation.Dto;

import java.util.Date;

public class BriefDto {

    private Long idBreif;

    private String titre;
    private Date dateDepart;
    private Date dateFin;

    public BriefDto(Long idBreif, String titre, Date dateDepart, Date dateFin) {
        this.idBreif = idBreif;
        this.titre = titre;
        this.dateDepart = dateDepart;
        this.dateFin = dateFin;
    }

    public BriefDto() {
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
