package com.example.wzr.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendNotice = (Button) findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.send_notice:
                        Intent intent = new Intent(MainActivity.this, NotificationActivity.class);
                        PendingIntent pi = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
                        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        Notification notification = new NotificationCompat.Builder(MainActivity.this)
                                .setContentTitle("This is content title")
                                .setContentText("This is content text")
                                .setWhen(System.currentTimeMillis())
                                .setSmallIcon(R.mipmap.ic_launcher)
                                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                                .setContentIntent(pi)
                                .setAutoCancel(true)
//                                .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Luna.ogg")))
//                                .setVibrate(new long[] {0, 500, 500, 500})
//                                .setLights(Color.GREEN, 1000, 1000)
//                                上面的三个设定可直接使用默认效果
//                                .setDefaults(NotificationCompat.DEFAULT_ALL)
//                                .setStyle(new NotificationCompat.BigTextStyle().bigText(
//                                        "Learn how to build notifications, send and sync data, " +
//                                                "and use voice actions.Get the offical Android IDE " +
//                                                "and developer tools to build apps for Android."))
                                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.big_image)))
                                .setPriority(NotificationCompat.PRIORITY_HIGH)
                                .build();
                        manager.notify(1, notification);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
