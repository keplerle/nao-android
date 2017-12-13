package com.example.kinma.test_call_ws.service;

import com.example.kinma.test_call_ws.model.Prof;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface ProfService {
    @GET("rest/prof")
    Call<Prof> getProfByMail(@Query("mail") String mail);

    @POST("rest/prof")
    Call<Prof> saveProf(@Body Prof prof);

    @DELETE("rest/prof")
    Call<Boolean> deleteProf(@Query("id") long id);

    @PUT("rest/prof")
    Call<Boolean> updateProf(@Body Prof prof);

}
