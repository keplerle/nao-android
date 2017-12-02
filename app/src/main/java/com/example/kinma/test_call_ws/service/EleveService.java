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

public interface EleveService {
    @GET("rest/eleve/{prof}")
    Call<Eleve> getEleve(@Path("prof") String prof);

    @POST("rest/eleve")
    @FormUrlEncoded
    Call<Eleve> saveEleve(@Body Eleve eleve);
/*
    @DELETE("/eleve/{id}")
    Call<Boolean> deleteEleve(@Path("id") long id);
*/
    @PUT("rest/eleve")
    Call<Boolean> updateEleve();


}
