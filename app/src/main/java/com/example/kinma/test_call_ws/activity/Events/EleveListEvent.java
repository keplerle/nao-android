package com.example.kinma.test_call_ws.activity.Events;

import com.example.kinma.test_call_ws.model.Eleve;

import java.util.List;


public class EleveListEvent {
    private List<Eleve> eleves;
    public EleveListEvent(List<Eleve> eleves){
        this.eleves=eleves;
    }

    public List<Eleve> getEleves() {
        return eleves;
    }
}
