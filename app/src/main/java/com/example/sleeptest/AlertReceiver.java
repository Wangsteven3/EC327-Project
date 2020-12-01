package com.example.sleeptest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class AlertReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Notification notification = new Notification(context);
        NotificationCompat.Builder noteBook = notification.getChannelNotification();
        notification.getManager().notify(1, noteBook.build());
    }
}
