package com.example.sleeptest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

//Resources I use for Android BroadcastReceiver
// Code in flow tutorial
// Also random Youtube videos
//https://www.tutorialspoint.com/android/android_broadcast_receivers.htm
//vogella.com/tutorials/AndroidBroadcastReceiver/article.html

public class AlertReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Notification notification = new Notification(context);
        NotificationCompat.Builder noteBook = notification.getChannelNotification(); //get Channel Notification
        notification.getManager().notify(1, noteBook.build());

    }
}
