package com.example.sportshub;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public static final String USERNAME_KEY = "USERNAME";
    public static final String PASSWORD_KEY = "PASSWORD";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView nameTextView = findViewById(R.id.nameTextView);

        Bundle data = getIntent().getExtras();
        String username = data.getString(USERNAME_KEY);
        String password = data.getString(PASSWORD_KEY);

        nameTextView.setText(username);

        Toast.makeText(this, password, Toast.LENGTH_LONG).show();
    }
}