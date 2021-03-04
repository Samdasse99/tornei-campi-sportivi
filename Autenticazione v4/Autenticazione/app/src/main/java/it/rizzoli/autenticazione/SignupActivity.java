package it.rizzoli.autenticazione;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import it.rizzoli.database.Utente;
import it.rizzoli.database.UtenteDbAdapter;

public class SignupActivity extends AppCompatActivity {

    UtenteDbAdapter userDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        userDb = new UtenteDbAdapter(this);
        userDb.open();

        EditText nomeEditText = findViewById(R.id.nameEditText);
        EditText cognomeEditText = findViewById(R.id.surnameEditText);
        EditText usernameEditText = findViewById(R.id.usernameEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        EditText etaEditText = findViewById(R.id.ageEditText);

        Button registerButton = findViewById(R.id.signupButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nomeEditText.getText().toString();
                String cognome = cognomeEditText.getText().toString();
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                int eta = 25;//Integer.getInteger(etaEditText.getText().toString());

                Utente user = new Utente();
                user.setNome(name);
                user.setCognome(cognome);
                user.setUsername(username);
                user.setPassword(password);
                user.setEta(eta);

                userDb.insertUser(user);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (userDb != null)
            userDb.close();
    }
}