package com.example.kinma.test_call_ws.event;

/**
 * Created by kinma on 28/11/2017.
 */

public class PleaseRefreshEvent {
    private String myString;

    public PleaseRefreshEvent(String myString){
        this.myString = myString;
    }

    public String getMyString(){
        return myString;
    }
}

