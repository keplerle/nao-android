package com.example.kinma.test_call_ws.model;

/**
 * Created by kinma on 28/11/2017.
 */

public class NAO {
    private String mailprof;
    private String ip;
    private String nom;
    private int etat_batterie;
    private int etat_moteur;
    private int niveau;
    private int operateur;
    private int code_signe;
    private int nbr_partie;


    public NAO() {
        super();
    }

    public int getCode_signe() {
        return code_signe;
    }

    public void setCode_signe(int code_signe) {
        this.code_signe = code_signe;
    }

    public void setMailprof(String mailprof) {
        this.mailprof = mailprof;
    }

    public String getMailprof() {
        return mailprof;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getEtat_batterie() {
        return etat_batterie;
    }

    public void setEtat_batterie(int etat_batterie) {
        this.etat_batterie = etat_batterie;
    }

    public int getEtat_moteur() {
        return etat_moteur;
    }

    public void setEtat_moteur(int etat_moteur) {
        this.etat_moteur = etat_moteur;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getOperateur() {
        return operateur;
    }

    public void setOperateur(int operateur) {
        this.operateur = operateur;
    }

    public int getNbr_partie() {
        return nbr_partie;
    }

    public void setNbr_partie(int nbr_partie) {
        this.nbr_partie = nbr_partie;
    }
}
