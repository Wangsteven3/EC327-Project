package com.example.sleeptest;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;

public class profile extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) { //profile xml

        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile); //profile xml

        //gradient background animation
        ConstraintLayout app = findViewById(R.id.profileLayout);
        AnimationDrawable gradientBackground = (AnimationDrawable) app.getBackground();
        gradientBackground.setEnterFadeDuration(1000);
        gradientBackground.setExitFadeDuration(3000);
        gradientBackground.start();

    }

    public void MenuClick(View v) { //button click listener for profile page menu button

        if (v.getId() == R.id.Bmenu) {

            Intent i = new Intent(profile.this, MainActivity.class);
            startActivity(i);

        }
    }
}

