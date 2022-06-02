package com.example.proiect_pdm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class AddMedActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private int notificationId = 1;
    Button add, cancel, data;
    TimePicker timePicker;
    EditText pil;
    String pillName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_med);

         add = findViewById(R.id.buttonadd);
         cancel = findViewById(R.id.buttonCancel);
         data = findViewById(R.id.buttdate);

         add.setOnClickListener(this);
         cancel.setOnClickListener(this);
         data.setOnClickListener(this);




    }
    public void showDatePickerDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                 this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();


    }


    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {




    }

    @Override
    public void onClick(View view) {

        pil = findViewById(R.id.pill);
        timePicker = findViewById(R.id.timeP);

        Intent intent = new Intent(AddMedActivity.this, AlarmReceiver.class);
        intent.putExtra("notificationId",notificationId);
        intent.putExtra("ToTake",pil.getText().toString());

        PendingIntent alarmIntent = PendingIntent.getBroadcast(AddMedActivity.this,0,intent,PendingIntent.FLAG_CANCEL_CURRENT);

        AlarmManager alarm = (AlarmManager) getSystemService(ALARM_SERVICE);

        if(data==view){
            showDatePickerDialog();

        }
        if (add==view) {
                int ora = timePicker.getCurrentHour();
                int minut = timePicker.getCurrentMinute();
                String pillname = pil.getText().toString();

                Calendar startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, ora);
                startTime.set(Calendar.MINUTE, minut);
                startTime.set(Calendar.SECOND, 0);

                long alarmStartTime = startTime.getTimeInMillis();

                alarm.set(AlarmManager.RTC_WAKEUP, alarmStartTime, alarmIntent);
                Toast.makeText(this, "DONE!", Toast.LENGTH_SHORT).show();
                pil.getText().clear();
        } else if (cancel==view) {
            Intent BacktoUserActivity = new Intent(getApplicationContext(), UserActivity.class);
            startActivity(BacktoUserActivity);
        }

    }
}