package com.example.sem_ex9_alarm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.time.LocalTime;

public class MainActivity extends AppCompatActivity {
    TimePicker tp;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tp = findViewById(R.id.tp);
        bt = findViewById(R.id.bt);
    }

    public void btclick(View view) {
        new Thread(new Alarmrunner()).start();
    }


    public class Alarmrunner implements Runnable{

        @Override
        public void run() {

            LocalTime localTime = LocalTime.now();
            int hrnow = localTime.getHour();
            int minnow = localTime.getMinute();

            int hralarm = tp.getHour();
            int minalarm = tp.getMinute();

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(MainActivity.this, "hralarm=" + String.valueOf(hralarm) + " minalarm=" + String.valueOf(minalarm), Toast.LENGTH_SHORT).show();

                }
            });



            while (hrnow != hralarm || minnow != minalarm) {
                localTime = LocalTime.now();
                hrnow = localTime.getHour();
                minnow = localTime.getMinute();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            showNotification();



        }

        void showNotification(){

            NotificationChannel channel=new NotificationChannel("MYID","MYID", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "MYID");

            builder.setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentTitle("Alarm");
            manager.notify(1, builder.build());
        }
    }
}