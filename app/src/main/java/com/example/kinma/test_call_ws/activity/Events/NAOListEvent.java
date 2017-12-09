package com.example.kinma.test_call_ws.activity.Events;

import com.example.kinma.test_call_ws.model.NAO;

import java.util.List;


public class NAOListEvent {
    private List<NAO> naos;
    public NAOListEvent(List<NAO> naos){
        this.naos = naos;
    }

    public List<NAO> getNaos() {
        return naos;
    }
}
