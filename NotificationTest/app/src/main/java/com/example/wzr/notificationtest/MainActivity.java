package com.example.wzr.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

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
