package com.example.sleeptest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Math extends AppCompatActivity{

        Random rand = new Random();
        int term1, term2, ans,rightbutton, correct;
        String expressiontext;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.math);

            Button one = (Button) findViewById(R.id.Answer1);
            Button two = (Button) findViewById(R.id.Answer2);
            Button three = (Button) findViewById(R.id.Answer3);
            Button four = (Button) findViewById(R.id.Answer4);
            Button back = (Button) findViewById(R.id.Back);
            TextView expression = (TextView) findViewById(R.id.expression);
            correct = 0;

            int operation = rand.nextInt(3); //add = 0, sub = 1, mul = 2, div = 3
            if(operation == 0 || operation == 1){
                term1 = rand.nextInt(200)-99;
                term2 = rand.nextInt(200)-99;
                ans = term1+term2;
            }
            if(operation == 2 || operation == 3){
                term1 = rand.nextInt(12)+1;
                term2 = rand.nextInt(100)+1;
                ans = term1*term2;
            }
            String[] oplist = {"+","-","x","/"};
            rightbutton = rand.nextInt(3);
            int[] wrongs = new int[4];
            for(int i = 0; i < 4; i++) wrongs[i] = (2*rand.nextInt(2)-1)*(rand.nextInt(50)+1);
            wrongs[rightbutton] = 0;
            if(operation % 2 == 0){
                expressiontext = term1 + oplist[operation] + term2;
                one.setText(ans+wrongs[0]);
                two.setText(ans+wrongs[1]);
                three.setText(ans+wrongs[2]);
                four.setText(ans+wrongs[3]);
            }
            else {
                expressiontext = ans + oplist[operation] + term1;
                one.setText(term2+wrongs[0]);
                two.setText(term2+wrongs[1]);
                three.setText(term2+wrongs[2]);
                four.setText(term2+wrongs[3]);
            }
            expression.setText(expressiontext);

            one.setOnClickListener(new View.OnClickListener() { //all the other buttons are derived from this general idea
                @Override
                public void onClick(View v) {
                    if(rightbutton == 0) correct++;
                }
            });

            two.setOnClickListener(new View.OnClickListener() { //all the other buttons are derived from this general idea
                @Override
                public void onClick(View v) {
                    if(rightbutton == 1) correct++;
                }
            });

            three.setOnClickListener(new View.OnClickListener() { //all the other buttons are derived from this general idea
                @Override
                public void onClick(View v) {
                    if(rightbutton == 2) correct++;
                }
            });

            four.setOnClickListener(new View.OnClickListener() { //all the other buttons are derived from this general idea
                @Override
                public void onClick(View v) {
                    if(rightbutton == 3) correct++;
                }
            });

            back.setOnClickListener(new View.OnClickListener() { //sends you back the home +
                @Override
                public void onClick(View v) {
                    Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(startIntent);
                }
            });






        }
    }
