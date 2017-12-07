package com.example.kinma.test_call_ws.activity.Events;

import com.example.kinma.test_call_ws.model.NAO;


public class NAOListEvent {
    private NAO nao;
    public NAOListEvent(NAO nao){
        this.nao = nao;
    }

    public NAO getNao() {
        return nao;
    }
}
