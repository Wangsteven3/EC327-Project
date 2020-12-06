package com.example.sleeptest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class profile extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) { //profile xml

        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile); //profile xml

    }

    public void MenuClick(View v) { //button click listener for profile page menu button

        if (v.getId() == R.id.Bmenu) {

            Intent i = new Intent(profile.this, MainActivity.class);
            startActivity(i);

        }
    }
}
