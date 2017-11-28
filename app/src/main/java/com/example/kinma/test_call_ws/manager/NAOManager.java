package com.example.kinma.test_call_ws.manager;

import com.example.kinma.test_call_ws.model.NAO;
import com.example.kinma.test_call_ws.service.NAOService;

import java.util.logging.Logger;

import de.greenrobot.event.EventBus;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class NAOManager {

    NAOService naoService;
    EventBus bus;
    private static final Logger LOGGER=Logger.getLogger("NAOManager");

    public NAOManager(NAOService naoService, EventBus bus) {
        this.naoService = naoService;
        this.bus = bus;

    }
    /*public NAOManager(){
        Retrofit retrofit=new Retrofit.Builder()
               // .baseUrl("http://api.example.com")
               // .baseUrl("http://localhost:8080")
                .baseUrl("http://192.168.2.1:8080")
                .build();
        this.naoService=retrofit.create(NAOService.class);
    }*/

    public void getNAO(){
        naoService.getNAO().enqueue(new Callback<NAO>(){
            @Override
            public void onResponse(Call<NAO> call, Response<NAO> response){
                //poste un evenement avec EventBus. L'evenement contient NAO
                NAO nao=response.body();

            }

            @Override
            public void onFailure(Call<NAO> call, Throwable t){
                t.printStackTrace();
            }
        });
    }
}
