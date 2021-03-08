package it.rizzoli.autenticazione;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private final static String MY_PREFERENCES = "AuthPrefs";
    private final static String USERNAME_KEY = "username";
    private final static String PASSWORD_KEY = "password";

    EditText usernameEditText;
    EditText passwordEditText;
    Button signupButton;
    Button signinButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        signupButton = findViewById(R.id.signupButton);
        signinButton = findViewById(R.id.signinButton);

        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (username.length() <= 0 || password.length() <= 0)
                    Toast.makeText(LoginActivity.this, "Username e password non validi", Toast.LENGTH_LONG).show();
                else {
                    savePreferencesData();

                    Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                    mainIntent.putExtra(SplashActivity.USERNAME_KEY, username);
                    mainIntent.putExtra(SplashActivity.PASSWORD_KEY, password);
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

    public void savePreferencesData() {
        // Otteniamo il riferimento alle Preferences
        SharedPreferences prefs = getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        // Otteniamo il corrispondente Editor
        SharedPreferences.Editor editor = prefs.edit();
        // Modifichiamo il valore con quello inserito nell'EditText
        if (usernameEditText != null && passwordEditText!= null) {
            // Lo salviamo nelle Preferences
            editor.putString(USERNAME_KEY, usernameEditText.getText().toString());
            editor.putString(PASSWORD_KEY, passwordEditText.getText().toString());
            editor.commit();
        }
    }

}