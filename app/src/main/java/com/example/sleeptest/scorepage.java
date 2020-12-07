package com.example.sleeptest;


import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import org.w3c.dom.Text;

import java.lang.*;

public class scorepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scorepage);
        Button back = (Button) findViewById(R.id.button18); //to go back to main

        float[] scorearray;
        //this is to get our scores from the previous games
        Bundle extras = getIntent().getExtras();
        scorearray = extras.getFloatArray("score");
        //declaration of text boxes to tell you your answer
        TextView twoxtwo = (TextView) findViewById(R.id.textView7);
        TextView threexthree = (TextView) findViewById(R.id.textView8);
        TextView fourxfour = (TextView) findViewById(R.id.textView9);
        TextView simon = (TextView) findViewById(R.id.textView10);
        TextView math = (TextView) findViewById(R.id.textView4);
        TextView finalscore = (TextView) findViewById(R.id.textView11);
        TextView scorenumber = (TextView) findViewById(R.id.score);
        Button copy = (Button) findViewById(R.id.copy);
        float score1 = scorearray[0] * 100; //turning the scores into percentages
        float score2 = scorearray[1] * 100;
        float score3 = scorearray[2] * 100;
//making sure you cant get below a 0 on the memorization games
        if(score1 < 0)
            score1 = 0;
        if(score2 < 0)
            score2 = 0;
        if(score3 < 0)
            score3 = 0;


        float score4 = scorearray[3]/6 * 100; //converts simon into a percentage
        float totalscore = (score1+score2+score3+score4+scorearray[4])/5; //calculates total score
        String percentscore = String.format("%.1f", totalscore); //makes it round to the 1st decimals when we display the answers
        String scoreone = String.format("%.1f", score1);
        String scoretwo = String.format("%.1f", score2);
        String scorethree = String.format("%.1f", score3);
        String scorefour = String.format("%.1f", score4);
        //displays the answer and the text size
        twoxtwo.setText("2x2 memorization: " + scoreone + "%");
        twoxtwo.setTextSize(18);
        threexthree.setText("3x3 memorization: " + scoretwo + "%");
        threexthree.setTextSize(18);
        fourxfour.setText("4x4 memorization: " + scorethree +"%");
        fourxfour.setTextSize(18);
        simon.setText("Simon: " + scorefour + "%");
        simon.setTextSize(18);
        math.setText("Math: " + scorearray[4] +"%");
        finalscore.setText("Your overall score in percent: ");
        finalscore.setTextSize(18);
        math.setTextSize(18);
        scorenumber.setText(percentscore + "%");
        scorenumber.setTextSize(18);

        copy.setOnClickListener(new View.OnClickListener() { //button we created to easily copy score to put in database
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                String text = percentscore + "%";
                ClipData clip = ClipData.newPlainText("label", text);
                clipboard.setPrimaryClip(clip);

            }
        });



        back.setOnClickListener(new View.OnClickListener() { //sends user back
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startIntent);
            }

        });


    }
}
