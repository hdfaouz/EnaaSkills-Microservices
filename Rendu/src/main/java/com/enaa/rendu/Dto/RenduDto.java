package com.enaa.rendu.Dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;


public class RenduDto {

    private Date DateDepot;
    private String contenu;

    public RenduDto(Date dateDepot, String contenu) {
        DateDepot = dateDepot;
        this.contenu = contenu;
    }

    public RenduDto() {
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

}
