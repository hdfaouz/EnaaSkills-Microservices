package com.enaa.rendu.Dto;


import java.io.Serializable;
import java.util.Date;


public class RenduDto implements Serializable {

    private Date DateDepot;
    private String contenu;
    private Long idApprenant;
    private Long idBreif;

    public RenduDto() {
    }

    public RenduDto(Date dateDepot, String contenu, Long idApprenant, Long idBreif) {
        DateDepot = dateDepot;
        this.contenu = contenu;
        this.idApprenant = idApprenant;
        this.idBreif = idBreif;
    }

    public Date getDateDepot() {
        return DateDepot;
    }

    public void setDateDepot(Date dateDepot) {
        DateDepot = dateDepot;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Long getIdApprenant() {
        return idApprenant;
    }

    public void setIdApprenant(Long idApprenant) {
        this.idApprenant = idApprenant;
    }

    public Long getIdBreif() {
        return idBreif;
    }

    public void setIdBreif(Long idBreif) {
        this.idBreif = idBreif;
    }
}
