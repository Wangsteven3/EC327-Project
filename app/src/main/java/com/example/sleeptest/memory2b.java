package com.example.sleeptest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sleeptest.MainActivity;
import com.example.sleeptest.R;

import java.util.Random;


public class memory2b extends AppCompatActivity {
    //Declaration of variables
    Random rand = new Random(); //we have the random class
    short redcounter, greencounter, bluecounter, yellowcounter, j = 0, accurate =0, incorrect=0, b1click =1, b2click = 1, b3click = 1, b4click = 1, totalrightsquares, submitted = 0;
    //the color counters are used so we can track how many total colors there are
    //j is just a counter for the while loop later on. Accurate and incorrect are used to keep count for final score
    //b1-4click act as on off switches later on


    int b1 = rand.nextInt(3); //we assign random number that assigns with a color to the button/square
    int b2 = rand.nextInt(3);
    int b3 = rand.nextInt(3);
    int b4 = rand.nextInt(3);

    int[] num = {b1,b2,b3,b4}; //this is used later on to keep track of colors



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memory2b);
        //creation of the buttons
        Button one = (Button) findViewById(R.id.button1);
        Button two = (Button) findViewById(R.id.button2);
        Button three = (Button) findViewById(R.id.button3);
        Button four = (Button) findViewById(R.id.button4);
        Button submission = (Button) findViewById(R.id.answer);
        TextView prompt = (TextView) findViewById(R.id.textView2);


        for(int i = 0; i < 4; i++) { //looping to get the total colors
            if(num[i] == 0)
                redcounter++;
            if(num[i]==1)
                greencounter++;
            if(num[i]==2)
                bluecounter++;
            if(num[i]==3)
                yellowcounter++;
        }


        int[] numpossibilities = {0,0,0,0}; //this int possibilities is used to know if there are a certain color, this makes sure it will never ask you to select colors
        //that don't exist
        if(redcounter != 0)
            numpossibilities[0] = 0;
        if(greencounter != 0)
            numpossibilities[1] = 1;
        if(bluecounter != 0)
            numpossibilities[2] = 2;
        if(yellowcounter != 0)
            numpossibilities[3] = 3;

        while(numpossibilities[j] == 0 && redcounter == 0) //here we use j to loop through, as long as j != 0 and redcounter doesn't equal 0 we increase j
            j++;


        //following sets all the colors of the buttons with if statements

        if(b1 == 0) {
            one.setBackgroundColor(Color.parseColor("#FF0000")); //red
        }
        if(b1 == 1) {
            one.setBackgroundColor(Color.parseColor("#04A104")); //green
        }
        if(b1 == 2) {
            one.setBackgroundColor(Color.parseColor("#0573FB")); //blue
        }
        if(b1 == 3) {
            one.setBackgroundColor(Color.parseColor("#F3FB05")); //yellow
        }



        if(b2 == 0) {
            two.setBackgroundColor(Color.parseColor("#FF0000"));
        }
        if(b2 == 1) {
            two.setBackgroundColor(Color.parseColor("#04A104"));
        }
        if(b2 == 2) {
            two.setBackgroundColor(Color.parseColor("#0573FB"));
        }
        if(b2 == 3) {
            two.setBackgroundColor(Color.parseColor("#F3FB05"));
        }



        if(b3 == 0) {
            three.setBackgroundColor(Color.parseColor("#FF0000"));
        }
        if(b3 == 1) {
            three.setBackgroundColor(Color.parseColor("#04A104"));
        }
        if(b3 == 2) {
            three.setBackgroundColor(Color.parseColor("#0573FB"));
        }
        if(b3 == 3) {
            three.setBackgroundColor(Color.parseColor("#F3FB05"));
        }



        if(b4 == 0) {
            four.setBackgroundColor(Color.parseColor("#FF0000"));
        }
        if(b4 == 1) {
            four.setBackgroundColor(Color.parseColor("#04A104"));
        }
        if(b4 == 2) {
            four.setBackgroundColor(Color.parseColor("#0573FB"));
        }
        if(b4 == 3) {
            four.setBackgroundColor(Color.parseColor("#F3FB05"));
        }


        //after the colors flash we will turn them white after 2/3 of a second

        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        one.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        two.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        three.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        four.setBackgroundColor(Color.parseColor("#FFFFFF"));

                        if (j == 0) { //the condition are based off the j value in the while loop. This will give us a color guarenteed and also make the prompt accordingly
                            prompt.setText("Tap the red squares.");
                            totalrightsquares = redcounter; //totalrightsquares will equal and correspond with the counter
                        }
                        if (j == 1) {
                            prompt.setText("Tap the green squares.");
                            totalrightsquares = greencounter;
                        }
                        if (j == 3) {
                            prompt.setText("Tap the yellow squares.");
                            totalrightsquares = greencounter;
                        }
                        if(j==2) {
                            prompt.setText("Tap the blue squares.");
                            totalrightsquares = bluecounter;
                        }

                    }
                },
                666
        );

        one.setOnClickListener(new View.OnClickListener() { //all the other buttons are derived from this general idea
            @Override
            public void onClick(View v) {
                b1click++; //as soon as you click you increment the associated click by 1

                if(b1click/2 == (float)b1click/2) { //acts as an on/off switch this is the "on"
                    one.setText("X"); //writes X to make it clear that you selected the button
                    one.setTextSize(14);
                    one.setTextColor(Color.parseColor("#000000"));
                    if(b1 == j)
                        accurate++;     //if you selected correctly the accuracy goes up by 1
                    else
                        incorrect++; //if not your incorrectedness goes up by 1

                }

                if(b1click/2 != (float)b1click/2) { //in the off case
                    one.setText("");
                    if(b1 != j)
                        incorrect--; //your incorrectness goes down by one if you unselect the correct answer
                    if(b1 == j)
                        accurate--; //if you unselected the correct answer your accuracy goes down by 1
                }
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b2click++;


                if(b2click/2 == (float)b2click/2) {
                    two.setText("X");
                    two.setTextSize(14);
                    two.setTextColor(Color.parseColor("#000000"));
                    if(b2 == j)
                        accurate++;
                    else
                        incorrect++;
                }

                if(b2click/2 != (float)b2click/2) {
                    two.setText("");
                    if(b2 != j)
                        incorrect--;
                    if(b2 == j)
                        accurate--;
                }

            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b3click++;

                if(b3click/2 == (float)b3click/2) {
                    three.setText("X");
                    three.setTextSize(14);
                    three.setTextColor(Color.parseColor("#000000"));
                    if(b3 == j)
                        accurate++;
                    else
                        incorrect++;
                }

                if(b3click/2 != (float)b3click/2) {
                    three.setText("");
                    if (b3 != j)
                        incorrect--;
                    if(b3 == j)
                        accurate--;

                }
            }
        });


        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b4click++;

                if(b4click/2 == (float)b4click/2) {
                    four.setText("X");
                    four.setTextSize(14);
                    four.setTextColor(Color.parseColor("#000000"));
                    if(b4 == j)
                        accurate++;
                    else
                        incorrect++;
                }

                if(b4click/2 != (float)b4click/2) {
                    four.setText("");
                    if (b4 != j) {
                        incorrect--;
                    }
                    if(b4 == j) {
                        accurate--;
                    }
                }

            }
        });


        submission.setOnClickListener(new View.OnClickListener() { //here is the submission button
            @Override
            public void onClick(View v) { //creates string prompt
                String prompt1 = "You selected " + accurate + " right out of " +totalrightsquares + " of the correct squares and selected " + incorrect + " wrong squares";
                prompt.setText(prompt1); //sets the textbox

                //bring back the colors
                if(b1 == 0) {
                    one.setBackgroundColor(Color.parseColor("#FF0000")); //red
                }
                if(b1 == 1) {
                    one.setBackgroundColor(Color.parseColor("#04A104")); //green
                }
                if(b1 == 2) {
                    one.setBackgroundColor(Color.parseColor("#0573FB")); //blue
                }
                if(b1 == 3) {
                    one.setBackgroundColor(Color.parseColor("#F3FB05")); //yellow
                }



                if(b2 == 0) {
                    two.setBackgroundColor(Color.parseColor("#FF0000"));
                }
                if(b2 == 1) {
                    two.setBackgroundColor(Color.parseColor("#04A104"));
                }
                if(b2 == 2) {
                    two.setBackgroundColor(Color.parseColor("#0573FB"));
                }
                if(b2 == 3) {
                    two.setBackgroundColor(Color.parseColor("#F3FB05"));
                }



                if(b3 == 0) {
                    three.setBackgroundColor(Color.parseColor("#FF0000"));
                }
                if(b3 == 1) {
                    three.setBackgroundColor(Color.parseColor("#04A104"));
                }
                if(b3 == 2) {
                    three.setBackgroundColor(Color.parseColor("#0573FB"));
                }
                if(b3 == 3) {
                    three.setBackgroundColor(Color.parseColor("#F3FB05"));
                }



                if(b4 == 0) {
                    four.setBackgroundColor(Color.parseColor("#FF0000"));
                }
                if(b4 == 1) {
                    four.setBackgroundColor(Color.parseColor("#04A104"));
                }
                if(b4 == 2) {
                    four.setBackgroundColor(Color.parseColor("#0573FB"));
                }
                if(b4 == 3) {
                    four.setBackgroundColor(Color.parseColor("#F3FB05"));
                }

                if(submitted == 0) {

                    float[] scorearray = {0, 0, 0, 0, 0};
                    float score = (float)(accurate ++- incorrect) / totalrightsquares;
                    scorearray[0] = score;
                    submitted++;
                    new java.util.Timer().schedule(
                            new java.util.TimerTask() {
                                @Override
                                public void run() {
                                    Intent i = new Intent(getApplicationContext(), memory3b.class);
                                    i.putExtra("score", scorearray);
                                    startActivity(i);
                                }
                            },
                            2000
                    );
                }
            }
        });



    }
}