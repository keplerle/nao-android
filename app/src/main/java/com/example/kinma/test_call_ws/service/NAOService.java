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

public interface NAOService {
    @GET("/nao/{ip}")
    Call<NAO> getNAO(@Path("ip") String ip);

    @POST("/nao")
    @FormUrlEncoded
    Call<NAO> saveNAO(@Body NAO nao);

    @DELETE("/nao/{ip}")
    Call<Boolean> deleteNAO(@Path("ip") String ip);

    @PUT("/nao")
    Call<Boolean> updateNAO();
}
