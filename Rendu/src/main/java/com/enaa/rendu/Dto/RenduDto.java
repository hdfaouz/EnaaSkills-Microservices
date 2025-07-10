package com.enaa.rendu.Dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class RenduDto {

    private Date DateDepot;
    private String contenu;
    private Long idApprenant;
    private Long idBreif;

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
