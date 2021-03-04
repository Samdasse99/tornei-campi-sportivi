package it.rizzoli.autenticazione;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import it.rizzoli.database.Utente;

public class UserListAdapter extends ArrayAdapter<Utente> {
    Context ctx;
    int res;

    public UserListAdapter(@NonNull Context context, int resource, ArrayList<Utente> users) {
        super(context, resource);

        addAll(users);

        ctx = context;
        res = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(res, parent, false);

        TextView nameTextView = rowView.findViewById(R.id.nameTextView);
        TextView surnameTextView = rowView.findViewById(R.id.surnameTextView);
        TextView ageTextView = rowView.findViewById(R.id.ageTextView);

        Utente u = getItem(position);
        String eta = "" + u.getEta();

        nameTextView.setText(u.getNome());
        surnameTextView.setText(u.getCognome());
        ageTextView.setText(eta);

        return rowView;
    }
}
