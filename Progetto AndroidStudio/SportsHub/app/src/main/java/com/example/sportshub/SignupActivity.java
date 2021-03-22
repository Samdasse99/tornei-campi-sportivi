package com.example.sportshub;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sportshub.model.Giocatore;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignupActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        EditText editNome = findViewById(R.id.EditNome);
        EditText editCognome = findViewById(R.id.EditCognome);
        EditText editIndirizzo = findViewById(R.id.EditIndirizzo);
        EditText editPaese = findViewById(R.id.EditPaese);
        EditText editUsername = findViewById(R.id.EditUsername);
        EditText editPassword = findViewById(R.id.EditPassword);
        Button button = findViewById(R.id.btn_register);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.14:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WebServiceInterface service = retrofit.create(WebServiceInterface.class);


        editNome.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                nome = editNome.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

        editCognome.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                cognome = editCognome.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

        editCognome.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                indirizzo = editIndirizzo.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });
        editCognome.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                paese = editPaese.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });
        editCognome.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                username = editUsername.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });
        editCognome.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                password = editPassword.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Giocatore giocatore = new Giocatore(username,nome,cognome,password,indirizzo,paese,"33333333");
                Call<Giocatore> call = service.registrazione(giocatore);
                call.enqueue(new Callback<Giocatore>() {
                    @Override
                    public void onResponse(Call<Giocatore> call, Response<Giocatore> response) {

                    }

                    @Override
                    public void onFailure(Call<Giocatore> call, Throwable t) {

                    }

                });

            }
        });



}
    String nome;
    String cognome;
    String indirizzo;
    String paese;
    String username;
    String password;
}