package com.example.kinma.test_call_ws.model;

/**
 * Created by kinma on 28/11/2017.
 */

public class NAO {
    private String mailprof;
    private String ip;
    private String nom;
    private int etat_robot;
    private boolean operande;
    private boolean operateur;
    private int code_signe;


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

    public int getEtatRobot() {
        return etat_robot;
    }

    public void setEtatRobot(int etatRobot) {
        this.etat_robot = etatRobot;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public boolean isOperande() {
        return operande;
    }

    public void setOperande(boolean operande) {
        this.operande = operande;
    }

    public boolean isOperateur() {
        return operateur;
    }

    public void setOperateur(boolean operateur) {
        this.operateur = operateur;
    }
}
