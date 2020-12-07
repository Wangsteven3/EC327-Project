package com.example.sleeptest;


import androidx.appcompat.app.AppCompatActivity;
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
        Button back = (Button) findViewById(R.id.button18);

        float[] scorearray;
        Bundle extras = getIntent().getExtras();
        scorearray = extras.getFloatArray("score");

        TextView twoxtwo = (TextView) findViewById(R.id.textView7);
        TextView threexthree = (TextView) findViewById(R.id.textView8);
        TextView fourxfour = (TextView) findViewById(R.id.textView9);
        TextView simon = (TextView) findViewById(R.id.textView10);
        TextView math = (TextView) findViewById(R.id.textView4);
        TextView finalscore = (TextView) findViewById(R.id.textView11);
        float score1 = scorearray[0] * 100;
        float score2 = scorearray[1] * 100;
        float score3 = scorearray[2] * 100;

        if(score1 < 0)
            score1 = 0;
        if(score2 < 0)
            score2 = 0;
        if(score3 < 0)
            score3 = 0;


        float score4 = scorearray[3]/6 * 100;
        float totalscore = (score1+score2+score3+score4+scorearray[4])/5;
        String percentscore = String.format("%.1f", totalscore);
        String scoreone = String.format("%.1f", score1);
        String scoretwo = String.format("%.1f", score2);
        String scorethree = String.format("%.1f", score3);
        String scorefour = String.format("%.1f", score4);

        twoxtwo.setText("2x2 memorization: " + scoreone + "%");
        twoxtwo.setTextSize(18);
        threexthree.setText("3x3 memorization: " + scoretwo + "%");
        threexthree.setTextSize(18);
        fourxfour.setText("4x4 memorization: " + scorethree +"%");
        fourxfour.setTextSize(18);
        simon.setText("Simon: " + scorefour + "%");
        simon.setTextSize(18);
        math.setText("Math: " + scorearray[4] +"%");
        finalscore.setText("Your overall score: " + percentscore + "%");
        finalscore.setTextSize(18);
        math.setTextSize(18);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startIntent);
            }

        });


    }
}
