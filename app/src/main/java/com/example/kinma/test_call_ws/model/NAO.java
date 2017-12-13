package com.example.kinma.test_call_ws.model;

/**
 * Created by kinma on 28/11/2017.
 */

public class NAO {
    private String mailprof;
    private String ip;
    private String nom;
    private int etatRobot;
    private int temperature_moteur;
    private int temperature_hardware;
    private int batterie;
    private boolean operande;
    private boolean operateur;
    private boolean plus;
    private boolean moins;
    private boolean multiple;
    private boolean divise;

    //private int signe_possible;

    public NAO() {
        super();
    }
/*
    public int getSigne_possible() {
        return signe_possible;
    }

    public void setSigne_possible(int signe_possible) {
        this.signe_possible = signe_possible;
    }*/

    public void setMailprof(String mailprof) {
        this.mailprof = mailprof;
    }

    public String getMailprof() {
        return mailprof;
    }

    public NAO(int etatRobot, String nomRobot, String ipRobot) {
        this.ip = ip;
        this.nom = nom;
        this.etatRobot = etatRobot;
    }
    public NAO(String nomRobot, String ipRobot) {
        this.ip = ip;
        this.nom = nom;
    }

    public int getTemperature_moteur() {
        return temperature_moteur;
    }


    public void setTemperature_moteur(int temperature_moteur) {
        this.temperature_moteur = temperature_moteur;
    }

    public int getTemperature_hardware() {
        return temperature_hardware;
    }

    public void setTemperature_hardware(int temperature_hardware) {
        this.temperature_hardware = temperature_hardware;
    }

    public int getBatterie() {
        return batterie;
    }

    public void setBatterie(int batterie) {
        this.batterie = batterie;
    }

    public boolean isPlus() {
        return plus;
    }

    public void setPlus(boolean plus) {
        this.plus = plus;
    }

    public boolean isMoins() {
        return moins;
    }

    public void setMoins(boolean moins) {
        this.moins = moins;
    }

    public boolean isMultiple() {
        return multiple;
    }

    public void setMultiple(boolean multiple) {
        this.multiple = multiple;
    }

    public boolean isDivise() {
        return divise;
    }

    public void setDivise(boolean divise) {
        this.divise = divise;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEtatRobot() {
        return etatRobot;
    }

    public void setEtatRobot(int etatRobot) {
        this.etatRobot = etatRobot;
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
