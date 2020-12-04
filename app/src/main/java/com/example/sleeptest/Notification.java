package com.example.sleeptest;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;


import androidx.core.app.NotificationCompat;

//source: Coding in Flow tutorial with Notification Manager

public class Notification extends ContextWrapper {

    //define parameters for one channel notification
    public static final String alertID = "Sleep Smart";
    public static final String alertName = "Alert";

    //define variable for Notification manager
    private NotificationManager myManager;

    //create channel if android build system is greater than Android os Oreo
    public Notification(Context base) {
        super(base);
        if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        createChannels();
    }

    //create channel function, requires API level 26 or greater
    @TargetApi(Build.VERSION_CODES.O)
    public void createChannels() {
        NotificationChannel alert;
        alert = new NotificationChannel(alertID, alertName, NotificationManager.IMPORTANCE_DEFAULT);

        getManager().createNotificationChannel(alert);
    }

    //Notification Manager
    protected NotificationManager getManager() {
        if(myManager == null) {
            myManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }

        return myManager;
    }

    //Set parameters of the notification message that users sees when alert pop up
    public NotificationCompat.Builder getChannelNotification() { //

        return new NotificationCompat.Builder(getApplicationContext(), alertID)
                .setContentTitle("Sleep Smart").setContentText("It's time for your test!")
                .setSmallIcon(R.drawable.ic_alarm); //setSmallIcon is mandatory

    }

}
