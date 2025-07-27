package com.enaa.rendu.dto;


import java.io.Serializable;

public class Apprenantdto implements Serializable {

    private Long idApprenant;
    private String nom;
    private String prenom;
    private String email;

    public Apprenantdto(Long idApprenant, String nom, String prenom, String email) {
        this.idApprenant = idApprenant;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    public Apprenantdto() {
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
