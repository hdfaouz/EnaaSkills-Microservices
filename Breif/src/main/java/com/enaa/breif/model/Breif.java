package com.enaa.breif.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity

public class Breif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long idBreif;
    private String titre;
    private Date dateDepart;
    private Date dateFin;

    public List<Long> getRendus() {
        return rendus;
    }

    public void setRendus(List<Long> rendus) {
        this.rendus = rendus;
    }

    @ElementCollection
    private List<Long> rendus;

    public Breif() {
    }

    public Breif(Long idBreif, String titre, Date dateDepart, Date dateFin) {
        this.idBreif = idBreif;
        this.titre = titre;
        this.dateDepart = dateDepart;
        this.dateFin = dateFin;
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
