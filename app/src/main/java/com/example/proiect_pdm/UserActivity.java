package com.example.proiect_pdm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonAdd, buttonView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        buttonAdd = findViewById(R.id.buttonAdauga);
        buttonView = findViewById(R.id.buttonVezi);

        buttonAdd.setOnClickListener(this);
        buttonView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view==buttonAdd){
            Intent intent = new Intent(getApplicationContext(), AddMedActivity.class);
            startActivity(intent);
        }

        if(view==buttonView){

            StringBuffer buffer = new StringBuffer();

            buffer.append("Nurofen"  + "\n");
            buffer.append("Paracetamol" + "\n");
            buffer.append("Parasinus" + "\n");
            buffer.append("Bixtonim"+ "\n");
            buffer.append("Theraflu"+ "\n");
            buffer.append("Acc"+ "\n");
            buffer.append("FaringoSept"+ "\n");
            buffer.append("Hexoraletten"+ "\n");
            buffer.append("Coldrex"+ "\n");


            showMessage("Data", buffer.toString());

        }

    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}





