package com.example.admin.alarm;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class MyReceiver extends BroadcastReceiver {

    public MyReceiver() { }

    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationCompat.Builder builder = new
                NotificationCompat.Builder(context)
                .setContentTitle("Some title")
                .setContentText("Some text")
                .setSmallIcon(android.R.drawable.btn_star);

        ((NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE))
                .notify(33, builder.build());

    }
}