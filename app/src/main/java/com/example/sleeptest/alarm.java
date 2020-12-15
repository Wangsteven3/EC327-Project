package com.example.sleeptest;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;

import java.text.DateFormat;
import java.util.Calendar;

//Resources I used to understand how to use built in android alarm system and time dialog widget
// Coding in Flow tutorial w/ Alarm Manager
// developer.android.com/reference/android/app/AlarmManager
// Types of customization to Android Clock intent on YouTube

public class alarm extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm); //alarm xml

        //gradient background animation
        ConstraintLayout app = findViewById(R.id.alarmLayout);
        AnimationDrawable gradientBackground = (AnimationDrawable) app.getBackground();
        gradientBackground.setEnterFadeDuration(1000);
        gradientBackground.setExitFadeDuration(3000);
        gradientBackground.start();

    }

    public void returnClick(View v) { //button click listener for alarm page menu button, direct alarm page back to menu

        if (v.getId() == R.id.Breturn) {

            Intent i = new Intent(alarm.this, MainActivity.class);
            startActivity(i);

        }
    }

                public void alarmSet(View v) { //button to open alarm dialog

                    DialogFragment timePick = new TimePicker();
                    timePick.show(getSupportFragmentManager(), "Time Picker");

                }

                public void cancel(View v) { //button to call cancelAlarm func

                    cancelAlarm();

                }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) { //to set time, update the inactive alarm textview and start alarm

        Calendar currentTime = Calendar.getInstance();
        currentTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
        currentTime.set(Calendar.MINUTE, minute);
        currentTime.set(Calendar.SECOND, 0);

//      TextView textView = (TextView)findViewById(R.id.textView);         test cases from previous without the alarmManager setup
//      textView.setText("Hour: " + hourOfDay + " Minute: " + minute);

        updateTimeText(currentTime);
        startAlarm(currentTime);

    }

    private void updateTimeText(Calendar currentTime) { //Change the Alarm inactive text to the time set on the alarm

        String timeTextView = "Set: "; //set time textView
        timeTextView += DateFormat.getTimeInstance(DateFormat.SHORT).format(currentTime.getTime());

        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(timeTextView);

    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void startAlarm(Calendar currentTime) { // function to start alarm using alarm manager

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class); //start a new intent to start alarm
        PendingIntent pending = PendingIntent.getBroadcast(this, 1, intent, 0);

            alarmManager.setExact(AlarmManager.RTC_WAKEUP, currentTime.getTimeInMillis(), pending);

    }


    private void cancelAlarm() { //function to cancel alarm, need to copy the same exact alarm in order to cancel

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent alarmOff = new Intent(this, AlertReceiver.class);
        PendingIntent pending = PendingIntent.getBroadcast(this, 1, alarmOff, 0);

        alarmManager.cancel(pending); //cancel alarm
        TextView textView = (TextView)findViewById(R.id.textView); //set textView label to alarm off
        textView.setText("Alarm Inactive");

    }


}
