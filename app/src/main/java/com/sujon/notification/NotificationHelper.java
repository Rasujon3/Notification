package com.sujon.notification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;

public class NotificationHelper extends ContextWrapper {

    public static  final  String channelId="SAMPLE_NOTIFICATION";
    public static  final  String channelName="NOTIFICATION_CHANNEL";
    private NotificationManager manager;

    public NotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            CreateChannel();
        }

    }
    @TargetApi(Build.VERSION_CODES.O)
    private void CreateChannel() {

        NotificationChannel channel=new NotificationChannel(channelId,channelName, NotificationManager.IMPORTANCE_DEFAULT);
        channel.enableVibration(true);
        channel.enableLights(true);
        channel.setLightColor(R.color.black);
        channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        getManager().createNotificationChannel(channel);
    }

    public  NotificationManager getManager(){
        if (manager==null){

            manager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        }
        return  manager;
    }
    public NotificationCompat.Builder getChannelNotification(String title, String message){
        Intent myinten=new Intent(this,MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,2,myinten,PendingIntent.FLAG_UPDATE_CURRENT);

        return new NotificationCompat.Builder(getApplicationContext(),channelId)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(R.drawable.notification_icon)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                ;

    }
}

