package com.example.fosterbrown.smartalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.util.Log;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button set_alarm;
    TimePicker timepick;
    AlarmManager am;
    Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        set_alarm = (Button) findViewById(R.id.set_alarm);
        timepick  = findViewById(R.id.time_pick);

        am = (AlarmManager) getSystemService(ALARM_SERVICE);


        set_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar.set(calendar.HOUR_OF_DAY, timepick.getHour());
                calendar.set(calendar.MINUTE,timepick.getMinute());

                Intent i = new Intent(MainActivity.this, AlarmReceiver.class);
                PendingIntent pi = PendingIntent.getBroadcast(getApplicationContext(),0,i,0);
                am.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pi);
                Log.d("tag", Integer.toString(calendar.HOUR_OF_DAY));

            }
        });


    }

}



