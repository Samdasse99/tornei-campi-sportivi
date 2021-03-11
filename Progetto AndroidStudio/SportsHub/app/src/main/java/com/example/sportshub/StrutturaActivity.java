package com.example.sportshub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;


public class StrutturaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonPaga = (Button) findViewById(R.id.buttonPaga);
        buttonPaga.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openPagamenti();
            }
        });
    }

    public void openPagamenti() {
        Intent intent = new Intent(this, PagaActivity.class);
        startActivity(intent);

    }

}






