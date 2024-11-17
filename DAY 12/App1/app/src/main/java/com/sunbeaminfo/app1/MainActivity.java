package com.sunbeaminfo.app1;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void tapNotification(View view){
        NotificationChannel channel = new NotificationChannel("MyChannelId","MyTest",NotificationManager.IMPORTANCE_DEFAULT);

        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);

        Intent intent = new Intent(this, DetailsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_IMMUTABLE);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"MyChannelId");
        builder.setSmallIcon(R.drawable.person);
        builder.setContentTitle("Tap Action");
        builder.setContentText("Tap this Notification");
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);

              if (ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED)
            return;
        NotificationManagerCompat.from(this).notify(1,builder.build());

    }

    public void sendProgressNotification(View view) {
        NotificationChannel notificationChannel = new NotificationChannel("MyChannelId", "MyTest", NotificationManager.IMPORTANCE_DEFAULT);

        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(notificationChannel);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "MyChannelId");
        builder.setSmallIcon(R.drawable.person);
        builder.setContentTitle("Hi");
        builder.setContentText("This is a test notification");
        int max_progress = 10;
        int current_progress = 0;
        builder.setProgress(max_progress, current_progress, false);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED)
            return;
        NotificationManagerCompat.from(this).notify(1, builder.build());

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    try {
                        Thread.sleep(1000);
                        builder.setProgress(max_progress, i, false);
                        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED)
                            return;
                        NotificationManagerCompat.from(MainActivity.this).notify(1, builder.build());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                builder.setContentText("Task finished");
                builder.setProgress(0, 0, false);
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED)
                    return;
                NotificationManagerCompat.from(MainActivity.this).notify(1, builder.build());

            }
        }).start();

    }
}