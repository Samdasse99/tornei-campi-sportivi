package com.example.sportshub;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApp extends Application {

    public WebServiceInterface initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.14:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WebServiceInterface service = retrofit.create(WebServiceInterface.class);
        return service;
    }
}


