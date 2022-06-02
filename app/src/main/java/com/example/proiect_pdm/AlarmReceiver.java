package com.example.proiect_pdm;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.EditText;

import androidx.annotation.RequiresApi;

import java.lang.reflect.Field;
import java.nio.file.attribute.AclEntryType;

public class AlarmReceiver  extends BroadcastReceiver {



    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override

    public void onReceive(Context context, Intent intent) {

        Intent mainIntent = new Intent(context,AddMedActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context,0,mainIntent,0);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,intent,0);

        String id ="channel_1";
        String description = "123";
        String pillname="";
        String msg = intent.getStringExtra("ToTake");
        int importance = NotificationManager.IMPORTANCE_LOW;
        try {
            Field pilname = AddMedActivity.class.getDeclaredField("pillname");
            pillname = pilname.toString();
            System.out.println(pillname);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel channel = new NotificationChannel(id, description, importance);

        manager.createNotificationChannel(channel);
        Notification notification = new Notification.Builder(context, id)
                .setCategory(Notification.CATEGORY_MESSAGE)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("Timpul pentru medicament!")
                .setContentText(msg)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();
        manager.notify(1, notification);
    }
}
