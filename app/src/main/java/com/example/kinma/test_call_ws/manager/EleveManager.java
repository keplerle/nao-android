package com.example.kinma.test_call_ws.manager;

import com.example.kinma.test_call_ws.model.Eleve;
import com.example.kinma.test_call_ws.service.EleveService;

import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class EleveManager {

   EleveService eleveService;
    private static final Logger LOGGER=Logger.getLogger("EleveManager");

    public EleveManager(){
        Retrofit retrofit=new Retrofit.Builder()
               // .baseUrl("http://api.example.com")
               // .baseUrl("http://localhost:8080")
                .baseUrl("http://192.168.2.1:8080")
                .build();
        this.eleveService=retrofit.create(EleveService.class);
    }

    public void getEleve(){
        eleveService.getEleve().enqueue(new Callback<Eleve>(){
            @Override
            public void onResponse(Call<Eleve> call, Response<Eleve> response){
                //poste un evenement avec EventBus. L'evenement contient Eleve
                Eleve eleve=response.body();

            }

            @Override
            public void onFailure(Call<Eleve> call, Throwable t){
                t.printStackTrace();
            }
        });
    }
}
