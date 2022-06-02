package com.example.proiect_pdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText nume, prenume, parola, username, reparola;
    Button sign_up;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nume = (EditText) findViewById(R.id.editNume);
        prenume = (EditText) findViewById(R.id.editPrenume);
        parola = (EditText) findViewById(R.id.editParola);
        reparola = (EditText) findViewById(R.id.editReParola);
        username = (EditText) findViewById(R.id.editUsername);
        sign_up = (Button) findViewById(R.id.buttonsign_up);
        DBhelper db = new DBhelper(this);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String numeString = nume.getText().toString();
                String prenumeString = prenume.getText().toString();
                String parolaString = parola.getText().toString();
                String reparolaString = reparola.getText().toString();
                String usernameString = username.getText().toString();


                if(numeString.equals("") || prenumeString.equals("") || parolaString.equals("") || usernameString.equals(""))
                    Toast.makeText(RegisterActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if(parolaString.equals(reparolaString)){
                        Boolean check = db.checkusername(usernameString);
                        if(check==false){
                            Boolean insert = db.insertData(numeString,prenumeString,parolaString,usernameString);
                            if(insert==true){
                                Toast.makeText(RegisterActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(RegisterActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(RegisterActivity.this, "Username already exists! please log in", Toast.LENGTH_SHORT).show();

                        }
                    }else{
                        Toast.makeText(RegisterActivity.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                } }


        });

    }
}