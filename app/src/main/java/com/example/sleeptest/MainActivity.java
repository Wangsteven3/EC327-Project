package com.example.sleeptest;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

//Resources: Use developer.android.com/training/basics/firstapp/starting-activity as reference for setting up activity
// as well as their Intent and layout for xml editing
//Gradient background: https://developer.android.com/reference/android/graphics/drawable/GradientDrawable
//Create a list of gradient background: https://stackoverflow.com/questions/38252362/how-to-animate-background-in-android-studio
//Setting up and writing animation instruction in res/anim folder - https://stackoverflow.com/questions/5151591/android-left-to-right-slide-animation

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) { //activity_main xml (home page)

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //gradient background animation
        ConstraintLayout app = findViewById(R.id.appLayout);
        AnimationDrawable gradientBackground = (AnimationDrawable) app.getBackground();
        gradientBackground.setEnterFadeDuration(1000);
        gradientBackground.setExitFadeDuration(5000);
        gradientBackground.start();

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

            //set animation when activity starts
            overridePendingTransition(R.anim.slide_right, R.anim.slide_right);

        }

    }

    public void play(View v) { //button click listener for alarm button in profile, direct the home page to alarm page

        if(v.getId() == R.id.choice) {

            Intent i = new Intent(MainActivity.this, gamemenu.class);
            startActivity(i);

        }

    }

}