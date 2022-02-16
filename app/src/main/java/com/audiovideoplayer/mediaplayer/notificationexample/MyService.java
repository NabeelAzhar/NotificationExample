package com.audiovideoplayer.mediaplayer.notificationexample;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.RemoteViews;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class MyService  extends Service {
    public static final String CHANNEL_ID = "channel1";
    public  static Notification notification;
    public static NotificationChannel channel;
    public  static  NotificationManager notificationManager;
    String audio;




    @Override
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            channel = new NotificationChannel(CHANNEL_ID,
                    "notification_songs", NotificationManager.IMPORTANCE_LOW);
            notificationManager = getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }

        } else {
            createNotification();
        }
    }




    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {




        if(intent!=null){

            audio = intent.getStringExtra("well_come");
            createNotification();
        }


        return START_STICKY;
    }

    private void createNotification() {
        RemoteViews notificationLayout = new RemoteViews(getPackageName(), R.layout.small_custom_notification);
        RemoteViews notificationLayoutExpanded = new RemoteViews(getPackageName(), R.layout.design_coustom_notification);
//        Button b1=(Button)conViews.findviewbyid(R.id.button1);
//        Button b2=(Button)conViews.findviewbyid(R.id.button2);
//        Button b3=(Button)conViews.findviewbyid(R.id.button3);
// Apply the layouts to the notification
         notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.music)
                .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                .setCustomContentView(notificationLayout)
                .setCustomBigContentView(notificationLayoutExpanded)
                .build();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
