package com.example.kinma.test_call_ws.activity.Events;

/**
 * Created by kinma on 30/11/2017.
 */

public class ConnexionEvent {

    private String message;
    public ConnexionEvent(String message){
        this.message=message;
    }

    public String getMessage() {
        return message;
    }
}
