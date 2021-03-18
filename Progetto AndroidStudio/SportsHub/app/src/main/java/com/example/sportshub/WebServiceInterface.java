package com.example.sportshub;

import com.example.sportshub.model.Giocatore;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface WebServiceInterface {
    @POST("giocatori")
    Call<Giocatore> registrazione(@Body Giocatore giocatore);
}
