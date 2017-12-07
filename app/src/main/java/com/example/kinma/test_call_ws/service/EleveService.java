package com.example.kinma.test_call_ws.service;

import com.example.kinma.test_call_ws.model.Eleve;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface EleveService {
    @GET("rest/eleve")
    Call<Eleve> getEleve(@Query("prof") String prof);

    @GET("rest/eleve/prof")
    Call<Eleve> getAllEleve(@Query("prof") String prof);

    @POST("rest/eleve")
    Call<Eleve> saveEleve(@Body Eleve eleve);

    @DELETE("/eleve")
    Call<Boolean> deleteEleve(@Query("id") Long id);

    @PUT("rest/eleve")
    Call<Boolean> updateEleve();


}
