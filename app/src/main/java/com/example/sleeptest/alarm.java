package com.example.sleeptest;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.text.DateFormat;
import java.util.Calendar;

public class alarm extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //alarm xml
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm); //alarm xml
    }

    public void returnClick(View v) { //button click listener for alarm page menu button

        if (v.getId() == R.id.Breturn) {

            Intent i = new Intent(alarm.this, MainActivity.class);
            startActivity(i);

        }
    }

//    Button button = (Button) findViewById(R.id.button);
//    button.setOnClickListener(new View.OnClickListener())  {
               // @Override
                public void alarmSet(View v) {
                    DialogFragment timePick = new TimePicker();
                    timePick.show(getSupportFragmentManager(), "Time Picker");

                }
//        }


                public void cancel(View v) {

                    cancelAlarm();

                }

//    @Override
//    public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
//        TextView textView = (TextView)findViewById(R.id.textView);
//        textView.setText("Hour: " + hourOfDay + " Minute: " + minute);
//    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {

        Calendar currentTime = Calendar.getInstance();
        currentTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
        currentTime.set(Calendar.MINUTE, minute);
        currentTime.set(Calendar.SECOND, 0);

//        TextView textView = (TextView)findViewById(R.id.textView);
//        textView.setText("Hour: " + hourOfDay + " Minute: " + minute);

        updateTimeText(currentTime);
        startAlarm(currentTime);

    }

    private void updateTimeText(Calendar currentTime) {

        String timeText = "Alarm set: ";
        timeText += DateFormat.getTimeInstance(DateFormat.SHORT).format(currentTime.getTime());

        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(timeText);

    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void startAlarm(Calendar currentTime) {

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

            alarmManager.setExact(AlarmManager.RTC_WAKEUP, currentTime.getTimeInMillis(), pendingIntent);

    }


    private void cancelAlarm() {

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

        alarmManager.cancel(pendingIntent);
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText("Alarm Off");

    }


}
