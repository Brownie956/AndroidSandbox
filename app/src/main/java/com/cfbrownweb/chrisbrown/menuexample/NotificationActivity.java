package com.cfbrownweb.chrisbrown.menuexample;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NotificationActivity extends AppCompatActivity {

    NotificationCompat.Builder notification;
    NotificationChannel notificationChannel;
    NotificationManager notificationManager;
    private static final int uniqueId = 4345345;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notificationChannel = new NotificationChannel("uniqueId", "something", NotificationManager.IMPORTANCE_DEFAULT);
        notificationManager.createNotificationChannel(notificationChannel);

        notification = new NotificationCompat.Builder(this, notificationChannel.getId()); // API 26^
//        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);
    }

    public void notificationButtonClicked(View view){
        notification.setSmallIcon(R.drawable.something);
        notification.setTicker("This is the ticker");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("Content title");
        notification.setContentText("Content text");

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        //Build notification and issue it
        notificationManager.notify(uniqueId, notification.build());
    }
}
