package it.rizzoli.autenticazione;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import it.rizzoli.database.Utente;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Utente> lista = new ArrayList<>();
        lista.add(new Utente("Antonio", "Lezzi", 27));
        lista.add(new Utente("Pippo", "Pluto", 37));
        lista.add(new Utente("Mario", "Rossi", 47));
        lista.add(new Utente("Giuseppe", "Verdi", 57));


        UserListAdapter userListAdapter = new UserListAdapter(this, R.layout.rowlist_user, lista);
        ListView userListView = findViewById(R.id.usersListView);
        userListView.setAdapter(userListAdapter);

        userListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Utente ut = userListAdapter.getItem(i);
                String nominativo = ut.getCognome() + " " + ut.getNome();
                Toast.makeText(MainActivity.this, nominativo, Toast.LENGTH_LONG).show();
            }
        });



/*        TextView nameTextView = findViewById(R.id.nameTextView);

        Bundle data = getIntent().getExtras();
        String username = data.getString(SplashActivity.USERNAME_KEY);
        String password = data.getString(SplashActivity.PASSWORD_KEY);

        nameTextView.setText(username);

        Toast.makeText(this, "La password è: " + password, Toast.LENGTH_LONG).show();*/
    }
}