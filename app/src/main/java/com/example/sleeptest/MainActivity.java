package com.example.sleeptest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v) { //button click listener for profile

        if(v.getId() == R.id.Bprofile) {

            Intent i = new Intent(MainActivity.this, profile.class);
            startActivity(i);

        }

    }


    public void alarmClick(View v) { //button click listener for alarm button in profile

        if(v.getId() == R.id.BsetAlarm) {

            Intent i = new Intent(MainActivity.this, alarm.class);
            startActivity(i);

        }

    }

}