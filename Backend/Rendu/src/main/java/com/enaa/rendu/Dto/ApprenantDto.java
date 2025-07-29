package com.enaa.rendu.Dto;


import java.io.Serializable;

public class ApprenantDto implements Serializable {

    private Long idApprenant;
    private String nom;
    private String prenom;
    private String email;

    public ApprenantDto(Long idApprenant, String nom, String prenom, String email) {
        this.idApprenant = idApprenant;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    public ApprenantDto() {
    }

    public Long getIdApprenant() {
        return idApprenant;
    }

    public void setIdApprenant(Long idApprenant) {
        this.idApprenant = idApprenant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
