package com.example.admin.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Not work on SDK28 (Android 9)
 */
public class MainActivity extends AppCompatActivity {

    private static final int PENDING_ALARM = 456;
    private EditText alarmInSec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarmInSec = findViewById(R.id.edit_alarm);
    }

    public void scheduleAlarm(View view) {

        try {
            int timeInSeconds = Integer.parseInt(alarmInSec.getText().toString());

            AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);

            manager.set(AlarmManager.RTC_WAKEUP,
                    System.currentTimeMillis() + timeInSeconds*1000,
                    getPendingIntent()
            );
        }
        catch (NumberFormatException ex){
            Toast.makeText(this, "Invalid number of seconds", Toast.LENGTH_LONG).show();
        }
    }

    private PendingIntent getPendingIntent()
    {
        /*
        Intent i = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this,
                PENDING_ALARM,
                i,
                PendingIntent.FLAG_UPDATE_CURRENT
        );
        */
        Intent i = new Intent(this, MyReceiver.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this,
                PENDING_ALARM,
                i,
                PendingIntent.FLAG_UPDATE_CURRENT
        );

        return pendingIntent;
    }
}