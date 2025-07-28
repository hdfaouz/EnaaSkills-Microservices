package com.enaa.rendu.Dto;


import lombok.Getter;

import java.io.Serializable;
import java.util.Date;


@Getter
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

    public void setDateDepot(Date dateDepot) {
        DateDepot = dateDepot;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setIdApprenant(Long idApprenant) {
        this.idApprenant = idApprenant;
    }

    public void setIdBreif(Long idBreif) {
        this.idBreif = idBreif;
    }
}
