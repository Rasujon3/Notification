package com.sujon.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity {

    NotificationHelper notificationHelper;
    NotificationManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationHelper = new NotificationHelper(this);
        manager = notificationHelper.getManager();
    }


    public void OnNotificationButtonClick(View view) {
        NotificationCompat.Builder nb = notificationHelper.getChannelNotification("This is Title", "This is message");
        manager.notify(1567,nb.build());
    }


}