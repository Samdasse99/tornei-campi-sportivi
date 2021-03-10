package com.example.sportshub;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

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
        EditText editRipassword = findViewById(R.id.EditRipassword);
}

}