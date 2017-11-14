package com.example.kinma.test_call_ws.manager;
import java.util.logging.Logger;
import com.example.kinma.test_call_ws.service.PersonService;
import com.example.kinma.test_call_ws.model.Person;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PersonManager {

    PersonService personService;
    private static final Logger LOGGER=Logger.getLogger("PersonManager");

    public PersonManager(){
        Retrofit retrofit=new Retrofit.Builder()
               // .baseUrl("http://api.example.com")
               // .baseUrl("http://localhost:8080")
                .baseUrl("http://192.168.2.1:8080")
                .build();
        this.personService=retrofit.create(PersonService.class);
    }

    public void getPerson(){
        personService.getPerson().enqueue(new Callback<Person>(){
            @Override
            public void onResponse(Call<Person> call, Response<Person> response){
                //poste un evenement avec EventBus. L'evenement contient Person
                Person person=response.body();
                LOGGER.info(person.getName());
                LOGGER.info(Integer.toString(person.getId()));
                LOGGER.info(Integer.toString(person.getAge()));
            }

            @Override
            public void onFailure(Call<Person> call, Throwable t){
                t.printStackTrace();
            }
        });
    }
}
