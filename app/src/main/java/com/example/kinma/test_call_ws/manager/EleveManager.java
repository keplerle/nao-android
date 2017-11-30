package com.example.kinma.test_call_ws.manager;

import com.example.kinma.test_call_ws.model.Eleve;
import com.example.kinma.test_call_ws.service.EleveService;

import java.util.logging.Logger;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class EleveManager {

    EleveService eleveService;
    EventBus bus;
    private static final Logger LOGGER = Logger.getLogger("EleveManager");


    public EleveManager() {
        Retrofit retrofit = new Retrofit.Builder()
                // .baseUrl("http://api.example.com")
                // .baseUrl("http://localhost:8080")
                .baseUrl("http://192.168.215.19:8080")
                .build();
        this.eleveService = retrofit.create(EleveService.class);
    }

    public void getEleve() {
        eleveService.getEleve().enqueue(new Callback<Eleve>() {
            @Override
            public void onResponse(Call<Eleve> call, Response<Eleve> response) {
                //poste un evenement avec EventBus. L'evenement contient Eleve
                Eleve eleve = response.body();
                EventBus.getDefault().post(eleve);
            }

            @Override
            public void onFailure(Call<Eleve> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void saveEleve(Eleve eleve) {
        eleveService.saveEleve(eleve).enqueue(new Callback<Eleve>() {
            @Override
            public void onResponse(Call<Eleve> call, Response<Eleve> response) {
                Eleve eleve = response.body();
                EventBus.getDefault().post(eleve);
            }

            @Override
            public void onFailure(Call<Eleve> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void deleteEleve(Long id) {
        eleveService.deleteEleve(id).enqueue(new Callback<Boolean>() {

            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {

            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t)  {
                t.printStackTrace();
            }
        });
    }


    public void updateEleve() {
        eleveService.updateEleve().enqueue(new Callback<Boolean>() {

            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {

            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t)   {
                t.printStackTrace();
            }
        });
    }

}
