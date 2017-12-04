package com.example.kinma.test_call_ws.activity.Events;

import com.example.kinma.test_call_ws.model.Prof;

/**
 * Created by kinma on 30/11/2017.
 */

public class ConnexionEvent {
    private Prof prof;
    public ConnexionEvent(Prof prof){
        this.prof=prof;
    }

    public Prof getProf() {
        return prof;
    }
}
