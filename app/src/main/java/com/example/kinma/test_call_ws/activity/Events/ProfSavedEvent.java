package com.example.kinma.test_call_ws.activity.Events;

import com.example.kinma.test_call_ws.model.Prof;

/**
 * Created by kinma on 30/11/2017.
 */

public class ProfSavedEvent {
    private Prof prof;
    public ProfSavedEvent(Prof prof){
        this.prof=prof;
    }
}
