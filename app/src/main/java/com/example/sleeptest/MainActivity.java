package com.example.sleeptest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) { //activity_main xml (home page)
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button begin = (Button) findViewById(R.id.start);


        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), memory2b.class);
                startActivity(startIntent);
            }
        });


    }

    public void onButtonClick(View v) { //button click listener for profile, direct the home page to profile page

        if(v.getId() == R.id.Bprofile) {

            Intent i = new Intent(MainActivity.this, profile.class);
            startActivity(i);

        }

    }


    public void alarmClick(View v) { //button click listener for alarm button in profile, direct the home page to alarm page

        if(v.getId() == R.id.BsetAlarm) {

            Intent i = new Intent(MainActivity.this, alarm.class);
            startActivity(i);

        }

    }

    public void play(View v) { //button click listener for alarm button in profile, direct the home page to alarm page

        if(v.getId() == R.id.choice) {

            Intent i = new Intent(MainActivity.this, gamemenu.class);
            startActivity(i);

        }

    }

}