package com.example.kinma.test_call_ws.service;

import com.example.kinma.test_call_ws.model.NAO;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NAOService {
    @GET("/nao")
    Call<NAO> getNAO();

}
