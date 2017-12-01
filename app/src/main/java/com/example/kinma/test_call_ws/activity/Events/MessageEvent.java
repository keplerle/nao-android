package com.example.kinma.test_call_ws.activity.Events;

/**
 * Created by kinma on 30/11/2017.
 */

public class MessageEvent {

    private String message;
    public MessageEvent(String message){
        this.message=message;
    }

    public String getMessage() {
        return message;
    }
}
