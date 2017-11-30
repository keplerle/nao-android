package com.example.kinma.test_call_ws.model;

/**
 * Created by kinma on 28/11/2017.
 */

public class Prof {
    private Long id;
    private String nom;
    private String prenom;
    private String mail;


    public Prof() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


}
