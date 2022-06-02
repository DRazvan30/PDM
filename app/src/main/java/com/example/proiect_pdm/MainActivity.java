package com.example.proiect_pdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button login, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (Button) findViewById(R.id.buttonLogin);
        register = (Button) findViewById(R.id.buttonRegister);
        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    public void onClick(View view){

        if (view == login){
            Intent intent_login = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent_login);
        }

        if( view == register){
            Intent intent_register = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent_register);
        }
    }
}