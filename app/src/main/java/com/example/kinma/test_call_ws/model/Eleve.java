package com.example.kinma.test_call_ws.model;

/**
 * Created by kinma on 28/11/2017.
 */

public class Eleve {
    private Long id;
    private String nom;
    private String prenom;
    private int bonne_reponse;
    private int fausse_reponse;

    public Eleve() {
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

    public int getBonne_reponse() {
        return bonne_reponse;
    }

    public void setBonne_reponse(int bonne_reponse) {
        this.bonne_reponse = bonne_reponse;
    }

    public int getFausse_reponse() {
        return fausse_reponse;
    }

    public void setFausse_reponse(int fausse_reponse) {
        this.fausse_reponse = fausse_reponse;
    }
}
