package com.enaa.breif.Dto;

public class Competencedto {
    private String nom;
    private boolean statutAcquise;

    public Competencedto() {
    }

    public Competencedto(String nom, boolean statutAcquise) {
        this.nom = nom;
        this.statutAcquise = statutAcquise;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isStatutAcquise() {
        return statutAcquise;
    }

    public void setStatutAcquise(boolean statutAcquise) {
        this.statutAcquise = statutAcquise;
    }
}
