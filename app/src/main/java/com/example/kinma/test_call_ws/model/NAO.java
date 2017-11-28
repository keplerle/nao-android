package com.example.kinma.test_call_ws.model;

/**
 * Created by kinma on 28/11/2017.
 */

public class NAO {
    private Long id;
    private int temperature_moteur;
    private int temperature_hardware;
    private int batterie;
    private boolean plus;
    private boolean moins;
    private boolean multiple;
    private boolean divise;

    public NAO() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
