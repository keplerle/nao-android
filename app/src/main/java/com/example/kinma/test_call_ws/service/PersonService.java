package com.example.kinma.test_call_ws.service;

import com.example.kinma.test_call_ws.model.Person;
import retrofit2.Call;
import retrofit2.http.GET;
public interface PersonService {
    @GET("/person")
    Call<Person> getPerson();

}
