package com.example.proiect_pdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText editUsername, editParola;
    Button buttonLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editUsername = (EditText) findViewById(R.id.editUsername);
        editParola = (EditText) findViewById(R.id.editParola);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        DBhelper db = new DBhelper(this);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usernameString = editUsername.getText().toString();
                String parolaString = editParola.getText().toString();

                if (usernameString.equals("admin") && parolaString.equals("admin")) {

                    Intent intent = new Intent(getApplicationContext(), AdminActivity.class);
                    startActivity(intent);

                } else {
                    if (usernameString.equals("") || parolaString.equals(""))
                        Toast.makeText(LoginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                    else {
                        Boolean check = db.checkuser_password(usernameString, parolaString);
                        if (check == false)
                            Toast.makeText(LoginActivity.this, "User not found,Register first!", Toast.LENGTH_SHORT).show();

                        else {
                            Toast.makeText(LoginActivity.this, "Login Succesfully!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), UserActivity.class);
                            startActivity(intent);

                        }
                    }
                }
            }

        });
    }
}