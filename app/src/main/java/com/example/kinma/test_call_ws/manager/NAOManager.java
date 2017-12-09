package com.example.kinma.test_call_ws.manager;

import com.example.kinma.test_call_ws.activity.Events.MessageEvent;
import com.example.kinma.test_call_ws.activity.Events.NAOListEvent;
import com.example.kinma.test_call_ws.activity.Events.NAOSavedEvent;
import com.example.kinma.test_call_ws.model.NAO;
import com.example.kinma.test_call_ws.service.NAOService;

import java.util.List;
import java.util.logging.Logger;

import org.greenrobot.eventbus.EventBus;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NAOManager {

    NAOService naoService;
    EventBus bus;
    private static final Logger LOGGER=Logger.getLogger("NAOManager");

    public NAOManager(NAOService naoService, EventBus bus) {
        this.naoService = naoService;
        this.bus = bus;

    }
    public NAOManager(){
        Retrofit retrofit=new Retrofit.Builder()
               // .baseUrl("http://api.example.com")
               // .baseUrl("http://localhost:8080")
                .baseUrl("http://192.168.0.34:8080/")
                .addConverterFactory(GsonConverterFactory.create())

                .build();
        this.naoService=retrofit.create(NAOService.class);
    }

    public void getNAOByIp(String ip) {
        naoService.getNAOip(ip).enqueue(new Callback<NAO>() {
            @Override
            public void onResponse(Call<NAO> call, Response<NAO> response) {
                //poste un evenement avec EventBus. L'evenement contient NAO
                NAO nao = response.body();
                EventBus.getDefault().post(nao);
            }

            @Override
            public void onFailure(Call<NAO> call, Throwable t) {
                t.printStackTrace();
                EventBus.getDefault().post(new MessageEvent("Impossible de récupérer le robot"));
            }
        });
    }


    public void getAllNAOByProf(String mailprof) {
        naoService.getAllNAOprof(mailprof).enqueue(new Callback<List<NAO>>() {
            @Override
            public void onResponse(Call<List<NAO>> call, Response<List<NAO>> response) {
                List<NAO> naos = response.body();
                EventBus.getDefault().post(new NAOListEvent(naos));
            }

            @Override
            public void onFailure(Call<List<NAO>> call, Throwable t) {
                t.printStackTrace();
                EventBus.getDefault().post(new MessageEvent("Impossible de récupérer le robot"));
            }
        });
    }

    public void saveNAO(NAO nao) {
        naoService.saveNAO(nao).enqueue(new Callback<NAO>() {
            @Override
            public void onResponse(Call<NAO> call, Response<NAO> response) {
                NAO nao = response.body();
                EventBus.getDefault().post(new NAOSavedEvent(nao));
            }

            @Override
            public void onFailure(Call<NAO> call, Throwable t) {
                t.printStackTrace();
                EventBus.getDefault().post(new MessageEvent("Impossible de synchroniser le robot"));
            }
        });
    }

    public void deleteNAO(String ip) {
        naoService.deleteNAO(ip).enqueue(new Callback<Boolean>() {

            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                EventBus.getDefault().post(new MessageEvent("Robot NAO supprimé"));
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t)  {
                t.printStackTrace();
                EventBus.getDefault().post(new MessageEvent("Impossible de supprimer le robot"));
            }
        });
    }


    public void updateNAO(NAO nao) {
        naoService.updateNAO(nao).enqueue(new Callback<NAO>() {

            @Override
            public void onResponse(Call<NAO> call, Response<NAO> response) {
                NAO nao = response.body();
                EventBus.getDefault().post(new NAOSavedEvent(nao));
            }

            @Override
            public void onFailure(Call<NAO> call, Throwable t)   {
                t.printStackTrace();
                EventBus.getDefault().post(new MessageEvent("Impossible de synchroniser le robot"));
            }
        });
    }
}
