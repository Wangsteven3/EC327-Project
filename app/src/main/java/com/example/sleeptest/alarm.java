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

//source: Coding in Flow tutorial with Alarm Manager

public class alarm extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

//    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm); //alarm xml
    }

    public void returnClick(View v) { //button click listener for alarm page menu button, direct alarm page back to menu

        if (v.getId() == R.id.Breturn) {

            Intent i = new Intent(alarm.this, MainActivity.class);
            startActivity(i);

        }
    }

                // @Override
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

//        TextView textView = (TextView)findViewById(R.id.textView);
//        textView.setText("Hour: " + hourOfDay + " Minute: " + minute);

        updateTimeText(currentTime);
        startAlarm(currentTime);

    }

    private void updateTimeText(Calendar currentTime) { //Change the Alarm inactive text to the time set on the alarm

        String timeText = "Set: ";
        timeText += DateFormat.getTimeInstance(DateFormat.SHORT).format(currentTime.getTime());

        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(timeText);

    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void startAlarm(Calendar currentTime) { // function to start alarm using alarm manager

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class); //start a new intent for alarm
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

            alarmManager.setExact(AlarmManager.RTC_WAKEUP, currentTime.getTimeInMillis(), pendingIntent);

    }


    private void cancelAlarm() { //function to cancel alarm, need to copy the same exact alarm in order to cancel

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

        alarmManager.cancel(pendingIntent); //cancel alarm
        TextView textView = (TextView)findViewById(R.id.textView); //set textView label to alarm off
        textView.setText("Alarm Inactive");

    }


}
