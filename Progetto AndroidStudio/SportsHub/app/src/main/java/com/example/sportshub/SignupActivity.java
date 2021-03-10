package com.example.sportshub;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sportshub.model.Giocatore;

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


        Giocatore giocatore = new Giocatore(username,nome,cognome,password,indirizzo,paese,"33333333");


}

    String nome;
    String cognome;
    String indirizzo;
    String paese;
    String username;
    String password;
}