package com.example.sleeptest;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

//Resources: Coding in Flow tutorial with Notification Manager
// Android developers documentation to start an activity from notification link : developer.android.com/training/notify-user/navigation

public class Notification extends ContextWrapper {

    //define parameters for single channel (app) notification for this app
    public static final String alertID = "Sleep Smart";

    //define variable for Notification manager called myManager
    private NotificationManager myManager;

    //Create channel if android build system is greater than Android os Oreo
    public Notification(Context base) {

        super(base);
        if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        createChannels();

    }

    //Create channel function, requires API level 26 or greater
    @TargetApi(Build.VERSION_CODES.O)
    public void createChannels() {

        NotificationChannel alert;
        alert = new NotificationChannel(alertID, "Alert", NotificationManager.IMPORTANCE_DEFAULT);

        getManager().createNotificationChannel(alert);

    }

    //Function to get notification Manager
    protected NotificationManager getManager() {

        if(myManager == null) {

            myManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        }

        return myManager;
    }

    //Create a function to set parameters of the notification message that users sees when alert pop up
    public NotificationCompat.Builder getChannelNotification() { //

        Intent newIntent = new Intent(this, MainActivity.class); //create a new intent for start an activity from notification
        PendingIntent returnToApp = PendingIntent.getActivity(this, 1, newIntent, PendingIntent.FLAG_UPDATE_CURRENT); //updating existing intent with new


        return new NotificationCompat.Builder(getApplicationContext(), alertID)
                .setContentTitle("Sleep Smart").setContentText("It's time for your test!").setAutoCancel(true)
                .setSmallIcon(R.drawable.ic_alarm).setContentIntent(returnToApp); //setSmallIcon is mandatory, Auto cancel to make the notification disappear if clicked, update intent

    }



}
