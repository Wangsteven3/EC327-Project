package com.example.sleeptest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.CountDownTimer;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.Random;
// THE B VARIATION OF THE CODE IS THE EXACT SAME AS THE NON-B COUNTERPART BUT CARRIES OVER DATA FROM THE CHAIN AND LINKS TO THE NEXT PROGRAM, CHANGES MADE AT THE BOTTOM
public class Mathb extends AppCompatActivity{

    Random rand = new Random();
    int term1, term2, ans,rightbutton, correct, rightanswer;
    boolean answered = false;
    double seconds;
    String expressiontext, option1, option2, option3, option4, summarytext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mathb);

        Button one = (Button) findViewById(R.id.Answer1);
        Button two = (Button) findViewById(R.id.Answer2);
        Button three = (Button) findViewById(R.id.Answer3);
        Button four = (Button) findViewById(R.id.Answer4);
        Button back = (Button) findViewById(R.id.Back);
        Button restart = (Button) findViewById(R.id.button17);
        TextView expression = (TextView) findViewById(R.id.expression);
        TextView countdown = (TextView) findViewById(R.id.countdown);
        TextView summary = (TextView) findViewById(R.id.summary);
        correct = 0;

        int operation = rand.nextInt(4); //add = 0, sub = 1, mul = 2, div = 3
        if(operation == 0 || operation == 1){
            seconds = 5;
            term1 = rand.nextInt(200)-99;
            term2 = rand.nextInt(200)-99;
            ans = term1+term2;
        }
        if(operation == 2 || operation == 3){
            seconds = 10;
            term1 = rand.nextInt(12)+1;
            term2 = rand.nextInt(100)+1;
            ans = term1*term2;
        }

        CountDownTimer timer = new CountDownTimer( (long)(1000*seconds),100){
            public void onTick(long millisUntilFinished){
                countdown.setText(String.format("%.1f", seconds));
                seconds-=.1;
            }
            public void onFinish(){
                answered = true;
                summarytext = "Sorry, you ran out of time.";
                countdown.setText("0");
                summary.setText(summarytext);
            }
        }.start();

        String[] oplist = {"+","-","x","/"};
        rightbutton = rand.nextInt(3);
        int[] wrongs = new int[4];
        for(int i = 0; i < 4; i++) wrongs[i] = (2*rand.nextInt(2)-1)*(rand.nextInt(50)+1);
        wrongs[rightbutton] = 0;
        if(operation % 2 == 0){
            expressiontext = term1 + " " + oplist[operation] + " " + term2;
            option1 = Integer.toString(ans+wrongs[0]);
            option2 = Integer.toString(ans+wrongs[1]);
            option3 = Integer.toString(ans+wrongs[2]);
            option4 = Integer.toString(ans+wrongs[3]);
            rightanswer = ans;

            one.setText(option1);
            two.setText(option2);
            three.setText(option3);
            four.setText(option4);
        }
        else {
            expressiontext = ans + " " + oplist[operation] + " " + term1;
            option1 = Integer.toString(term2+wrongs[0]);
            option2 = Integer.toString(term2+wrongs[1]);
            option3 = Integer.toString(term2+wrongs[2]);
            option4 = Integer.toString(term2+wrongs[3]);
            rightanswer = term2;
            one.setText(option1);
            two.setText(option2);
            three.setText(option3);
            four.setText(option4);
        }
        expression.setText(expressiontext);

        one.setOnClickListener(new View.OnClickListener() { //all the other buttons are derived from this general idea
            @Override
            public void onClick(View v) {
                if(!answered){
                    if(rightbutton == 0){
                        summarytext = "Correct!";
                        correct++;
                    }
                    else summarytext = "Incorrect, the correct answer is " + rightanswer;
                    timer.cancel();
                    answered = true;
                    summary.setText(summarytext);
                }
            }
        });

        two.setOnClickListener(new View.OnClickListener() { //all the other buttons are derived from this general idea
            @Override
            public void onClick(View v) {
                if(!answered){
                    if(rightbutton == 1){
                        summarytext = "Correct!";
                        correct++;
                    }
                    else summarytext = "Incorrect, the correct answer is " + rightanswer;
                    timer.cancel();
                    answered = true;
                    summary.setText(summarytext);
                }
            }

        });

        three.setOnClickListener(new View.OnClickListener() { //all the other buttons are derived from this general idea
            @Override
            public void onClick(View v) {
                if(!answered){
                    if(rightbutton == 2){
                        summarytext = "Correct!";
                        correct++;
                    }
                    else summarytext = "Incorrect, the correct answer is " + rightanswer;
                    timer.cancel();
                    answered = true;
                    summary.setText(summarytext);
                }
            }
        });

        four.setOnClickListener(new View.OnClickListener() { //all the other buttons are derived from this general idea
            @Override
            public void onClick(View v) {
                if(!answered){
                    if(rightbutton == 3){
                        summarytext = "Correct!";
                        correct++;
                    }
                    else summarytext = "Incorrect, the correct answer is " + rightanswer;
                    timer.cancel();
                    answered = true;
                    summary.setText(summarytext);
                }
            }
        });



        back.setOnClickListener(new View.OnClickListener() { //sends you back the home +
            @Override
            public void onClick(View v) {
                //sets up new scorearray and updates it
                float[] scorearray;
                Bundle extras = getIntent().getExtras();
                scorearray = extras.getFloatArray("score");
                if(correct == 1) {
                    scorearray[4] = 100;
                } else
                    scorearray[4] = 0;
                //sends to scorepage and updates score sheet
                Intent i = new Intent(getApplicationContext(), scorepage.class);
                i.putExtra("score", scorearray);
                startActivity(i);
            }
        });

    }
}
