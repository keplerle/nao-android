package com.example.kinma.test_call_ws.service;

import com.example.kinma.test_call_ws.model.Eleve;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface EleveService {
    @GET("/eleve")
    Call<Eleve> getEleve();

    @POST("/eleve")
    Call<Eleve> saveEleve(Eleve eleve);

    @DELETE("/eleve")
    Call<Boolean> supprEleve();

    @PUT("/eleve")
    Call<Boolean> updateEleve();
}
