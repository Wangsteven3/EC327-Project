package com.example.sleeptest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class alarm extends Activity {

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





}
