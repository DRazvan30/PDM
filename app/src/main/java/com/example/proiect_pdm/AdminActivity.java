package com.example.proiect_pdm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AdminActivity extends AppCompatActivity implements View.OnClickListener {

    DBhelper myDb;
    Button users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        myDb = new DBhelper(this);
        users = (Button) findViewById(R.id.buttonUsers);
        users.setOnClickListener((View.OnClickListener) this);

    }


    @Override
    public void onClick(View view) {

        if(view==users){
            
            Cursor res = myDb.getAll();
            if(res.getCount() == 0) {

                showMessage("Error","Nothing found");
                return;
            }

            StringBuffer buffer = new StringBuffer();
            while (res.moveToNext()) {
                buffer.append("Nume :"+ res.getString(0)+"\n");
                buffer.append("Prenume :"+ res.getString(1)+"\n");
                buffer.append("Parola :"+ res.getString(2)+"\n");
                buffer.append("Username :"+ res.getString(3)+"\n\n");
            }


            showMessage("Data",buffer.toString());
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