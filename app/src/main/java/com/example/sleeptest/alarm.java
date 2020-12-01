package com.example.sleeptest;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class alarm extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

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

    @Override
    public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText("Hour: " + hourOfDay + " Minute: " + minute);
    }
}
