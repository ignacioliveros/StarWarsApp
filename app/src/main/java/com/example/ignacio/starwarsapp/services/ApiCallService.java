package com.example.ignacio.starwarsapp.services;

import com.example.ignacio.starwarsapp.model.PeopleResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Ignacio on 2/13/2018.
 */

public interface ApiCallService {

    String BASE_URL = "http://swapi.co/api/";


    Retrofit retrofit= new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("people")
    Call<PeopleResponse> getCharactersResponse();
}
