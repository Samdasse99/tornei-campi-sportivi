package com.example.sportshub;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText usernameEditText = findViewById(R.id.usernameEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        Button signupButton = findViewById(R.id.signupButton);
        Button signinButton = findViewById(R.id.signinButton);

        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (username.length() <= 0 || password.length() <= 0)
                    Toast.makeText(LoginActivity.this, "Username e password non validi", Toast.LENGTH_LONG).show();
                else {
                    Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                    mainIntent.putExtra(MainActivity.USERNAME_KEY, username);
                    mainIntent.putExtra(MainActivity.PASSWORD_KEY, password);
                    startActivity(mainIntent);
                    finish();
                }
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registratiIntent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(registratiIntent);
            }
        });
    }

}


