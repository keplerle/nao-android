package com.example.kinma.test_call_ws.manager;


import com.example.kinma.test_call_ws.activity.Events.ConnexionEvent;
import com.example.kinma.test_call_ws.activity.Events.MessageEvent;
import com.example.kinma.test_call_ws.activity.Events.ProfSavedEvent;
import com.example.kinma.test_call_ws.model.Prof;
import com.example.kinma.test_call_ws.service.ProfService;

import org.greenrobot.eventbus.EventBus;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfManager {

    ProfService profService;
    EventBus bus;
    private static final Logger LOGGER = Logger.getLogger("ProfManager");


    public ProfManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.20.10.2:8080/")
                .addConverterFactory(GsonConverterFactory.create())

                .build();
        this.profService = retrofit.create(ProfService.class);
    }
/*
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
                EventBus.getDefault().post(new MessageEvent("Impossible de récuperer le prof"));
            }
        });
    }*/

    public void getProfByMail(String mail) {
        profService.getProfByMail(mail).enqueue(new Callback<Prof>() {
            @Override
            public void onResponse(Call<Prof> call, Response<Prof> response) {
                //poste un evenement avec EventBus. L'evenement contient Prof
                Prof prof = response.body();
                EventBus.getDefault().post(new ConnexionEvent(prof));
            }

            @Override
            public void onFailure(Call<Prof> call, Throwable t) {
                t.printStackTrace();
                EventBus.getDefault().post(new MessageEvent("Connexion échoué"));
            }
        });
    }

    public void saveProf(Prof prof) {
        profService.saveProf(prof).enqueue(new Callback<Prof>() {
            @Override
            public void onResponse(Call<Prof> call, Response<Prof> response) {
                Prof prof = response.body();
                EventBus.getDefault().post(new ProfSavedEvent(prof));

            }

            @Override
            public void onFailure(Call<Prof> call, Throwable t) {

                t.printStackTrace();
                EventBus.getDefault().post(new MessageEvent("Impossible de créer le prof"));
            }
        });
    }

    public void deleteProf(Long id) {
        profService.deleteProf(id).enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                EventBus.getDefault().post(new MessageEvent("Prof supprimé de la BDD"));
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {

                t.printStackTrace();
                EventBus.getDefault().post(new MessageEvent("Impossible de supprimer le prof"));
            }
        });
    }
    public void updateProf(Prof prof) {
        profService.updateProf(prof).enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                EventBus.getDefault().post(new MessageEvent("Prof à jour"));
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {

                t.printStackTrace();
                EventBus.getDefault().post(new MessageEvent("Impossible de modifier le prof"));
            }
        });
    }
}
