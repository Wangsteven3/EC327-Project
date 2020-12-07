package com.example.sleeptest;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class scorepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scorepage);
        Button back = (Button) findViewById(R.id.button18);

        //gradient background animation
        ConstraintLayout app = findViewById(R.id.scorepageLayout);
        AnimationDrawable gradientBackground = (AnimationDrawable) app.getBackground();
        gradientBackground.setEnterFadeDuration(1000);
        gradientBackground.setExitFadeDuration(5000);
        gradientBackground.start();


        float[] scorearray;
        Bundle extras = getIntent().getExtras();
        scorearray = extras.getFloatArray("score");

        TextView twoxtwo = (TextView) findViewById(R.id.textView7);
        TextView threexthree = (TextView) findViewById(R.id.textView8);
        TextView fourxfour = (TextView) findViewById(R.id.textView9);
        TextView simon = (TextView) findViewById(R.id.textView10);
        TextView finalscore = (TextView) findViewById(R.id.textView11);
        float score1 = scorearray[0] * 100;
        float score2 = scorearray[1] * 100;
        float score3 = scorearray[2] * 100;
        float score4 = scorearray[3]/8 * 100;
        float totalscore = (score1+score2+score3+score4)/4;

        twoxtwo.setText("For the 2x2 memorization game you got: " + score1 + "%");
        threexthree.setText("For the 3x3 memorization game you got: " + score2 + "%");
        fourxfour.setText("For the 4x4 memorization game you got: " + score3 +"%");
        simon.setText("For the simon game you got: " + score4 + "%");
        finalscore.setText("Your overall score is: " + totalscore + "%");



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startIntent);
            }

        });


    }
}