package com.enaa.rendu.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
public class Rendu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private Date DateDepot;
    private String contenu;

    public Rendu() {
    }

    public Rendu(Long id, Date dateDepot, String contenu) {
        this.id = id;
        DateDepot = dateDepot;
        this.contenu = contenu;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
