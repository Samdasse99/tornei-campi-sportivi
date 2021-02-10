package com.example.sportshub;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity {
    import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

import it.rizzoli.database.UtenteDbAdapter;


    public class SplashActivity extends AppCompatActivity {
        private final static int SPLASH_TIMER = 1000;
        private final static String MY_PREFERENCES = "AuthPrefs";
        public final static String USERNAME_KEY = "username";
        public final static String PASSWORD_KEY = "password";

        private final static String USERNAME_PREF = "Senza Nome";
        private final static String PASSWORD_PREF = "Bohhhh";

        String username;
        String password;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash);

            updatePreferencesData();

            //Per fare un esempio didattico vado a leggere tutti i record memorizzati
            //nel DB nella tabella Utenti
            UtenteDbAdapter userDb = new UtenteDbAdapter(this);
            userDb.open();
            Cursor c = userDb.fetchAllUsers();
            if (c != null && c.getCount() > 0) {
                c.moveToFirst();

                do {
                    Log.i("NOME", c.getString(c.getColumnIndex(UtenteDbAdapter.UTENTE_NAME_KEY)));
                    Log.i("COGNOME", c.getString(c.getColumnIndex(UtenteDbAdapter.UTENTE_SURNAME_KEY)));
                    Log.i("USERNAME", c.getString(c.getColumnIndex(UtenteDbAdapter.UTENTE_USERNAME_KEY)));
                    Log.i("PASSWRD", c.getString(c.getColumnIndex(UtenteDbAdapter.UTENTE_PASSWORD_KEY)));
                }
                while (c.moveToNext());
            }

            userDb.close();





            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
/*                if (!username.equals(USERNAME_PREF) && !password.equals(PASSWORD_PREF)) {
                    Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                    //Passaggio di parametri dalla schermata presente a MainActivity
                    mainIntent.putExtra(SplashActivity.USERNAME_KEY, username);
                    mainIntent.putExtra(SplashActivity.PASSWORD_KEY, password);
                    startActivity(mainIntent);
                    finish();
                }

                else {*/
                    Intent loginIntent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(loginIntent);
                    finish();
                    //}
                }
            }, SPLASH_TIMER);
        }

        private void updatePreferencesData(){
            // Leggiamo le Preferences
            SharedPreferences prefs = getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
            // Leggiamo l'informazione associata alla proprietà TEXT_DATA
            username = prefs.getString(USERNAME_KEY, USERNAME_PREF);
            password = prefs.getString(PASSWORD_KEY, PASSWORD_PREF);
        }
    }
}
