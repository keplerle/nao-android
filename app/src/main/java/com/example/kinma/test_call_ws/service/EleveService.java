package com.example.kinma.test_call_ws.service;

import com.example.kinma.test_call_ws.model.Eleve;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EleveService {
    @GET("/eleve")
    Call<Eleve> getEleve();

}
