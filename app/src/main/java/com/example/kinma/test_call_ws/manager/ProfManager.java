package com.example.kinma.test_call_ws.manager;

import com.example.kinma.test_call_ws.model.Prof;
import com.example.kinma.test_call_ws.service.ProfService;

import org.greenrobot.eventbus.EventBus;

import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProfManager {

    ProfService profService;
    EventBus bus;
    private static final Logger LOGGER = Logger.getLogger("ProfManager");


    public ProfManager() {
        Retrofit retrofit = new Retrofit.Builder()
                // .baseUrl("http://api.example.com")
                // .baseUrl("http://localhost:8080")
                .baseUrl("http://192.168.215.19:8080")
                .build();
        this.profService = retrofit.create(ProfService.class);
    }

    public void getProf() {
        profService.getProf().enqueue(new Callback<Prof>() {
            @Override
            public void onResponse(Call<Prof> call, Response<Prof> response) {
                //poste un evenement avec EventBus. L'evenement contient Prof
                Prof prof = response.body();
                EventBus.getDefault().post(prof);
            }

            @Override
            public void onFailure(Call<Prof> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
