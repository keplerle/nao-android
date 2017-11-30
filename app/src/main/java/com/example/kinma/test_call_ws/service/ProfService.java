package com.example.kinma.test_call_ws.service;

import com.example.kinma.test_call_ws.model.Prof;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ProfService {
    @GET("/prof")
    Call<Prof> getProf();

    @POST("/prof")
    @FormUrlEncoded
    Call<Prof> saveProf(@Body Prof prof);

    @DELETE("/prof/{id}")
    Call<Boolean> deleteProf(@Path("id") long id);

    @PUT("/prof")
    Call<Boolean> updateProf();
}
