package com.example.sportshub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RicercaCampoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ricerca_campo);

        Button buttonPaga = (Button) findViewById(R.id.btn_risultato1);
        buttonPaga.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openRisultato();
            }
        });
    }
    public void  openRisultato() {
        Intent intent = new Intent(this,PagaActivity.class);
        startActivity(intent);


    }
}