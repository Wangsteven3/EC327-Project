package com.example.sleeptest;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;


import androidx.core.app.NotificationCompat;

public class Notification extends ContextWrapper {

    //string constants
    public static final String alertID = "Sleep Smart";
    public static final String alertName = "Alert 1";

    private NotificationManager myManager;

    public Notification(Context base) {
        super(base);
        if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        createChannels();
    }

    @TargetApi(Build.VERSION_CODES.O)
    public void createChannels() {
        NotificationChannel alert;
        alert = new NotificationChannel(alertID, alertName, NotificationManager.IMPORTANCE_DEFAULT);

        getManager().createNotificationChannel(alert);
    }

    protected NotificationManager getManager() {
        if(myManager == null) {
            myManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }

        return myManager;
    }

    public NotificationCompat.Builder getChannelNotification() {
        
        return new NotificationCompat.Builder(getApplicationContext(), alertID).setContentTitle("Sleep Smart").setContentText("It's time for your test!");
        //.setSmallIcon(R.drawable.ic_android);

    }

}
