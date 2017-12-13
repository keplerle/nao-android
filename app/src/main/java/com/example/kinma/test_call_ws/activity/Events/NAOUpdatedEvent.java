package com.example.kinma.test_call_ws.activity.Events;

import com.example.kinma.test_call_ws.model.NAO;


public class NAOUpdatedEvent {
    private NAO nao;
    public NAOUpdatedEvent(NAO nao){
        this.nao = nao;
    }

    public NAO getNao() {
        return nao;
    }
}
