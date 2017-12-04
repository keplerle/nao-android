package com.example.kinma.test_call_ws.service;

import com.example.kinma.test_call_ws.model.NAO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NAOService {
    @GET("rest/nao")
    Call<NAO> getNAO(@Query("ip") String ip);

    @POST("rest/nao")
    @FormUrlEncoded
    Call<NAO> saveNAO(@Body NAO nao);

    @DELETE("rest/nao")
    Call<Boolean> deleteNAO(@Query("ip") String ip);

    @PUT("rest/nao")
    Call<Boolean> updateNAO();
}
