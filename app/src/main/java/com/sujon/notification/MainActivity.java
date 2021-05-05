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
    String CHANNEL_ID = "MyChannel";
    String notificationName = "MyNotification";
    NotificationCompat.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificationChannel();

        builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("My Notification Title")
                .setContentText("This is a notification from android")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = notificationName;
            String description = "For showing notification";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public void OnNotificationButtonClick(View view){
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        
        notificationManager.notify(1547, builder.build());
        }




}