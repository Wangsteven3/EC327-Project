package com.example.sleeptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.Random;


public class memory3 extends AppCompatActivity {
    Random rand = new Random(); //we have the random class
    short redcounter, greencounter, bluecounter, yellowcounter, j = 0, accurate =0, incorrect=0, b1click =1, b2click = 1, b3click = 1, b4click = 1, b5click = 1, b6click = 1, b7click = 1, b8click = 1, b9click =1, totalrightsquares;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memory3);
        //creation of the buttons

        //Declaration of variables
        //the color counters are used so we can track how many total colors there are
        //j is just a counter for the while loop later on. Accurate and incorrect are used to keep count for final score
        //b1-4click act as on off switches later on


        int b1 = rand.nextInt(3); //we assign random number that assigns with a color to the button/square
        int b2 = rand.nextInt(3);
        int b3 = rand.nextInt(3);
        int b4 = rand.nextInt(3);
        int b5 = rand.nextInt(3);
        int b6 = rand.nextInt(3);
        int b7 = rand.nextInt(3);
        int b8 = rand.nextInt(3);
        int b9 = rand.nextInt(3);


        int[] num = {b1,b2,b3,b4,b5,b6,b7,b8,b9}; //this is used later on to keep track of colors





        Button one = (Button) findViewById(R.id.button1);
        Button two = (Button) findViewById(R.id.button2);
        Button three = (Button) findViewById(R.id.button3);
        Button four = (Button) findViewById(R.id.button4);
        Button five = (Button) findViewById(R.id.button5);
        Button six = (Button) findViewById(R.id.button6);
        Button seven = (Button) findViewById(R.id.button7);
        Button eight = (Button) findViewById(R.id.button8);
        Button nine = (Button) findViewById(R.id.button9);
        Button repeat = (Button) findViewById(R.id.restart);

        Button back = (Button) findViewById(R.id.main);
        Button submission = (Button) findViewById(R.id.answer);
        TextView prompt = (TextView) findViewById(R.id.textView2);


        for(int i = 0; i < 9; i++) { //looping to get the total colors
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

        if(b5 == 0) {
            five.setBackgroundColor(Color.parseColor("#FF0000")); //red
        }
        if(b5 == 1) {
            five.setBackgroundColor(Color.parseColor("#04A104")); //green
        }
        if(b5 == 2) {
            five.setBackgroundColor(Color.parseColor("#0573FB")); //blue
        }
        if(b5 == 3) {
            five.setBackgroundColor(Color.parseColor("#F3FB05")); //yellow
        }

        if(b6 == 0) {
            six.setBackgroundColor(Color.parseColor("#FF0000")); //red
        }
        if(b6 == 1) {
            six.setBackgroundColor(Color.parseColor("#04A104")); //green
        }
        if(b6 == 2) {
            six.setBackgroundColor(Color.parseColor("#0573FB")); //blue
        }
        if(b6 == 3) {
            six.setBackgroundColor(Color.parseColor("#F3FB05")); //yellow
        }

        if(b7 == 0) {
            seven.setBackgroundColor(Color.parseColor("#FF0000")); //red
        }
        if(b7 == 1) {
            seven.setBackgroundColor(Color.parseColor("#04A104")); //green
        }
        if(b7== 2) {
            seven.setBackgroundColor(Color.parseColor("#0573FB")); //blue
        }
        if(b7 == 3) {
            seven.setBackgroundColor(Color.parseColor("#F3FB05")); //yellow
        }

        if(b8 == 0) {
            eight.setBackgroundColor(Color.parseColor("#FF0000")); //red
        }
        if(b8 == 1) {
            eight.setBackgroundColor(Color.parseColor("#04A104")); //green
        }
        if(b8 == 2) {
            eight.setBackgroundColor(Color.parseColor("#0573FB")); //blue
        }
        if(b8 == 3) {
            eight.setBackgroundColor(Color.parseColor("#F3FB05")); //yellow
        }

        if(b9 == 0) {
            nine.setBackgroundColor(Color.parseColor("#FF0000")); //red
        }
        if(b9 == 1) {
            nine.setBackgroundColor(Color.parseColor("#04A104")); //green
        }
        if(b9 == 2) {
            nine.setBackgroundColor(Color.parseColor("#0573FB")); //blue
        }
        if(b9 == 3) {
            nine.setBackgroundColor(Color.parseColor("#F3FB05")); //yellow
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
                        five.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        six.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        seven.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        eight.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        nine.setBackgroundColor(Color.parseColor("#FFFFFF"));

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

        five.setOnClickListener(new View.OnClickListener() { //all the other buttons are derived from this general idea
            @Override
            public void onClick(View v) {
                b5click++; //as soon as you click you increment the associated click by 1

                if(b5click/2 == (float)b5click/2) { //acts as an on/off switch this is the "on"
                    five.setText("X"); //writes X to make it clear that you selected the button
                    five.setTextSize(14);
                    five.setTextColor(Color.parseColor("#000000"));
                    if(b5 == j)
                        accurate++;     //if you selected correctly the accuracy goes up by 1
                    else
                        incorrect++; //if not your incorrectedness goes up by 1

                }

                if(b5click/2 != (float)b5click/2) { //in the off case
                    five.setText("");
                    if(b5 != j)
                        incorrect--; //your incorrectness goes down by one if you unselect the correct answer
                    if(b5 == j)
                        accurate--; //if you unselected the correct answer your accuracy goes down by 1
                }
            }
        });

        six.setOnClickListener(new View.OnClickListener() { //all the other buttons are derived from this general idea
            @Override
            public void onClick(View v) {
                b6click++; //as soon as you click you increment the associated click by 1

                if(b6click/2 == (float)b6click/2) { //acts as an on/off switch this is the "on"
                    six.setText("X"); //writes X to make it clear that you selected the button
                    six.setTextSize(14);
                    six.setTextColor(Color.parseColor("#000000"));
                    if(b6 == j)
                        accurate++;     //if you selected correctly the accuracy goes up by 1
                    else
                        incorrect++; //if not your incorrectedness goes up by 1

                }

                if(b6click/2 != (float)b6click/2) { //in the off case
                    six.setText("");
                    if(b6 != j)
                        incorrect--; //your incorrectness goes down by one if you unselect the correct answer
                    if(b6 == j)
                        accurate--; //if you unselected the correct answer your accuracy goes down by 1
                }
            }
        });

        seven.setOnClickListener(new View.OnClickListener() { //all the other buttons are derived from this general idea
            @Override
            public void onClick(View v) {
                b7click++; //as soon as you click you increment the associated click by 1

                if(b7click/2 == (float)b7click/2) { //acts as an on/off switch this is the "on"
                    seven.setText("X"); //writes X to make it clear that you selected the button
                    seven.setTextSize(14);
                    seven.setTextColor(Color.parseColor("#000000"));
                    if(b7 == j)
                        accurate++;     //if you selected correctly the accuracy goes up by 1
                    else
                        incorrect++; //if not your incorrectedness goes up by 1

                }

                if(b7click/2 != (float)b7click/2) { //in the off case
                    seven.setText("");
                    if(b7 != j)
                        incorrect--; //your incorrectness goes down by one if you unselect the correct answer
                    if(b7 == j)
                        accurate--; //if you unselected the correct answer your accuracy goes down by 1
                }
            }
        });


        eight.setOnClickListener(new View.OnClickListener() { //all the other buttons are derived from this general idea
            @Override
            public void onClick(View v) {
                b8click++; //as soon as you click you increment the associated click by 1

                if(b8click/2 == (float)b8click/2) { //acts as an on/off switch this is the "on"
                    eight.setText("X"); //writes X to make it clear that you selected the button
                    eight.setTextSize(14);
                    eight.setTextColor(Color.parseColor("#000000"));
                    if(b8 == j)
                        accurate++;     //if you selected correctly the accuracy goes up by 1
                    else
                        incorrect++; //if not your incorrectedness goes up by 1

                }

                if(b8click/2 != (float)b8click/2) { //in the off case
                    eight.setText("");
                    if(b8 != j)
                        incorrect--; //your incorrectness goes down by one if you unselect the correct answer
                    if(b8 == j)
                        accurate--; //if you unselected the correct answer your accuracy goes down by 1
                }
            }
        });

        nine.setOnClickListener(new View.OnClickListener() { //all the other buttons are derived from this general idea
            @Override
            public void onClick(View v) {
                b9click++; //as soon as you click you increment the associated click by 1

                if(b9click/2 == (float)b9click/2) { //acts as an on/off switch this is the "on"
                    nine.setText("X"); //writes X to make it clear that you selected the button
                    nine.setTextSize(14);
                    nine.setTextColor(Color.parseColor("#000000"));
                    if(b9 == j)
                        accurate++;     //if you selected correctly the accuracy goes up by 1
                    else
                        incorrect++; //if not your incorrectedness goes up by 1

                }

                if(b9click/2 != (float)b9click/2) { //in the off case
                    nine.setText("");
                    if(b9 != j)
                        incorrect--; //your incorrectness goes down by one if you unselect the correct answer
                    if(b9 == j)
                        accurate--; //if you unselected the correct answer your accuracy goes down by 1
                }
            }
        });


        submission.setOnClickListener(new View.OnClickListener() { //here is the submission button
            @Override
            public void onClick(View v) { //creates string prompt
                String prompt1 = "You selected " + accurate + " right out of " + totalrightsquares;
                prompt1 = prompt1 + " of the correct squares and selected " + incorrect + " wrong squares";
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


                if(b5 == 0) {
                    five.setBackgroundColor(Color.parseColor("#FF0000"));
                }
                if(b5 == 1) {
                    five.setBackgroundColor(Color.parseColor("#04A104"));
                }
                if(b5 == 2) {
                    five.setBackgroundColor(Color.parseColor("#0573FB"));
                }
                if(b5 == 3) {
                    five.setBackgroundColor(Color.parseColor("#F3FB05"));
                }

                if(b6 == 0) {
                    six.setBackgroundColor(Color.parseColor("#FF0000"));
                }
                if(b6 == 1) {
                    six.setBackgroundColor(Color.parseColor("#04A104"));
                }
                if(b6 == 2) {
                    six.setBackgroundColor(Color.parseColor("#0573FB"));
                }
                if(b6 == 3) {
                    six.setBackgroundColor(Color.parseColor("#F3FB05"));
                }

                if(b7 == 0) {
                    seven.setBackgroundColor(Color.parseColor("#FF0000"));
                }
                if(b7 == 1) {
                    seven.setBackgroundColor(Color.parseColor("#04A104"));
                }
                if(b7 == 2) {
                    seven.setBackgroundColor(Color.parseColor("#0573FB"));
                }
                if(b7 == 3) {
                    seven.setBackgroundColor(Color.parseColor("#F3FB05"));
                }

                if(b8 == 0) {
                    eight.setBackgroundColor(Color.parseColor("#FF0000"));
                }
                if(b8 == 1) {
                    eight.setBackgroundColor(Color.parseColor("#04A104"));
                }
                if(b8 == 2) {
                    eight.setBackgroundColor(Color.parseColor("#0573FB"));
                }
                if(b8 == 3) {
                    eight.setBackgroundColor(Color.parseColor("#F3FB05"));
                }

                if(b9 == 0) {
                    nine.setBackgroundColor(Color.parseColor("#FF0000"));
                }
                if(b9 == 1) {
                    nine.setBackgroundColor(Color.parseColor("#04A104"));
                }
                if(b9 == 2) {
                    nine.setBackgroundColor(Color.parseColor("#0573FB"));
                }
                if(b9 == 3) {
                    nine.setBackgroundColor(Color.parseColor("#F3FB05"));
                }




            }
        });


        back.setOnClickListener(new View.OnClickListener() { //sends you back the home +
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startIntent);
            }
        });

        repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), memory3.class);
                startActivity(startIntent);
            }
        });






    }
}