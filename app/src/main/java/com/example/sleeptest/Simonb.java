package com.example.sleeptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.*;
import java.util.Random;

public class Simonb extends AppCompatActivity {


    int counter, score, over;
    String order = "";


    //this piece of code was taken from: https://www.zidsworld.com/android-development/stop-other-sounds-when-new-sound-is-selected-in-android-java/
    //the reason why this code is needed is because if you hit the same button too fast the audio doesnt play
    //I googled how to fix this and this is the only solution that worked and i tried different variations of it but it didn't work, and its neccessary to have
    //a smooth experience, I cited the code from the link above and will continue commenting it to show i do understand what it is doing
    //I went over this with Daniel and he said its okay due to it being a minor part and that i did cite this code
    public MediaPlayer sound;
    public void playAudio(int audioID) //function name and audioID passed to it has an int value (the sound files from R.raw.name is an int value
    {
        if(sound != null && sound.isPlaying()) //we declare sound as a public variable and we're seeing if it is playing or if its linked to anything
        {
            sound.stop(); //if so we stop it
            sound.release(); //unassociate what its playing
            sound = null;
        }
        sound = MediaPlayer.create(this, audioID); //then we create the new sound
        sound.start(); //and play it
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        counter = 0; score = 0; over = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simonb);
        //creation of sounds, buttons and text
        Button back = (Button) findViewById(R.id.back);
        Button redbtn = (Button) findViewById(R.id.redbtn);
        Button greenbtn = (Button) findViewById(R.id.greenbtn);
        Button bluebtn = (Button) findViewById(R.id.bluebtn);
        Button yellowbtn = (Button) findViewById(R.id.yellowbtn);
        TextView text = (TextView) findViewById(R.id.textView);
        final MediaPlayer redbeep = MediaPlayer.create(this, R.raw.red);
        final MediaPlayer bluebeep = MediaPlayer.create(this, R.raw.blue);
        final MediaPlayer greenbeep = MediaPlayer.create(this, R.raw.green);
        final MediaPlayer yellowbeep = MediaPlayer.create(this, R.raw.yellow);
        final MediaPlayer error = MediaPlayer.create(this, R.raw.error);
        TextView test = (TextView) findViewById(R.id.test);

        Random rand = new Random(); //random num gen for colors and sequence

        int[] sequence = {0,0,0,0,0,0};

        for(int i = 0; i < 6; i++) //generates sequence
        {
            sequence[i] = rand.nextInt(3);
        }

        for (int i = 0; i < 6; i++) { //red = 0, green = 1, yellow = 2, blue = 3
            int var = sequence[i];
            new java.util.Timer().schedule( //plays sequence and color with delay in order
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            redbtn.setBackgroundColor(Color.parseColor("#9E0E0E")); //0
                            greenbtn.setBackgroundColor(Color.parseColor("#056725")); //1
                            yellowbtn.setBackgroundColor(Color.parseColor("#8F8108")); //2
                            bluebtn.setBackgroundColor(Color.parseColor("#072583")); //3

                            new java.util.Timer().schedule(
                                    new java.util.TimerTask() {
                                        @Override
                                        public void run() {
                                            if (var == 0) {
                                                redbtn.setBackgroundColor(Color.parseColor("#ff0438"));
                                                playAudio(R.raw.red);
                                            }

                                            if (var == 1) {
                                                greenbtn.setBackgroundColor(Color.parseColor("#02fd04"));
                                                playAudio(R.raw.green);
                                            }

                                            if (var == 2) {
                                                yellowbtn.setBackgroundColor(Color.parseColor("#fffd38"));
                                                playAudio(R.raw.yellow);
                                            }

                                            if (var == 3) {
                                                bluebtn.setBackgroundColor(Color.parseColor("#02b9ff"));
                                                playAudio(R.raw.blue);
                                            }


                                        }
                                    }, 100
                            );


                            /*
                            if (var == 0) {
                                redbtn.setBackgroundColor(Color.parseColor("#ff0438"));
                                redbeep.start();
                            }

                            if (var == 1) {
                                greenbtn.setBackgroundColor(Color.parseColor("#02fd04"));
                                greenbeep.start();
                            }

                            if (var == 2) {
                                yellowbtn.setBackgroundColor(Color.parseColor("#fffd38"));
                                yellowbeep.start();
                            }

                            if (var == 3) {
                                bluebtn.setBackgroundColor(Color.parseColor("#02b9ff"));
                                bluebeep.start();
                            }
                            */



                        }
                    }, 1000*i+1

            );
        }

/*
            for(int i = 0; i < 6; i++) {
                if(sequence[i] == 0)
                    order = order + "red " + sequence[i] + " ";
                if(sequence[i] == 1)
                    order = order + "green " + sequence[i] + " ";
                if(sequence[i] == 2)
                    order = order + "yellow " + sequence[i] + " ";
                if(sequence[i] == 3)
                    order = order + "blue " + sequence[i] + " ";
            }
            test.setText(order);
*/

        new java.util.Timer().schedule( //sets back to base colors after sequence play
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        redbtn.setBackgroundColor(Color.parseColor("#9E0E0E"));
                        greenbtn.setBackgroundColor(Color.parseColor("#056725"));
                        bluebtn.setBackgroundColor(Color.parseColor("#072583"));
                        yellowbtn.setBackgroundColor(Color.parseColor("#8F8108"));
                    }
                }, 1000*6+1+700
        );


        redbtn.setOnClickListener(new View.OnClickListener() { //all other buttons are the same but with diff values, same format
            @Override
            public void onClick(View v) {
                if (over == 0) { //we created a var named over to check if the game was over if not do the following code
                    if (sequence[counter] != 0 && over == 0) { //if the person got the sequence it will print out the prompt of how many was correct and what was the order, checks if counter index
                        String prompt;                              //and actual sequence are equal
                        for (int i = 0; i < 6; i++) {
                            if (sequence[i] == 0)
                                order = order + "red ";
                            if (sequence[i] == 1)
                                order = order + "green ";
                            if (sequence[i] == 2)
                                order = order + "yellow ";
                            if (sequence[i] == 3)
                                order = order + "blue ";
                        }
                        prompt = "You only got " + score + " right, the correct order was: " + order;
                        text.setText(prompt);
                        playAudio(R.raw.error);
                        over++;
                    }
                    if (sequence[counter] == 0 && over == 0) {//if it was correct plays sound and increases score
                        score++;
                        playAudio(R.raw.red);


                    }
                    counter++; //counter increases
                    if (score == 6 && over == 0) { //if the game isnt over and score is full congrats
                        String yadiditson = "You got it all right!";
                        text.setText(yadiditson);
                        over++;
                    }
                } else {
                    playAudio(R.raw.red);

                }
            }

        });

        greenbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (over == 0) {
                    if (sequence[counter] != 1 && over == 0) {
                        String prompt;
                        for (int i = 0; i < 6; i++) {
                            if (sequence[i] == 0)
                                order = order + "red ";
                            if (sequence[i] == 1)
                                order = order + "green ";
                            if (sequence[i] == 2)
                                order = order + "yellow ";
                            if (sequence[i] == 3)
                                order = order + "blue ";
                        }

                        prompt = "You only got " + score + " right, the correct order was: " + order;
                        text.setText(prompt);
                        over++;
                        playAudio(R.raw.error);

                    }
                    if (sequence[counter] == 1) {
                        playAudio(R.raw.green);
                        score++;
                    }
                    counter++;
                    if (score == 6 && over == 0) {
                        String yadiditson = "You got it all right!";
                        text.setText(yadiditson);
                        over++;
                    }
                } else
                    playAudio(R.raw.green);
            }
        });

        yellowbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (over == 0) {
                    if (sequence[counter] != 2 && over == 0) {
                        String prompt;
                        for (int i = 0; i < 6; i++) {
                            if (sequence[i] == 0)
                                order = order + "red ";
                            if (sequence[i] == 1)
                                order = order + "green ";
                            if (sequence[i] == 2)
                                order = order + "yellow ";
                            if (sequence[i] == 3)
                                order = order + "blue ";
                        }

                        prompt = "You only got " + score + " right, the correct order was: " + order;
                        text.setText(prompt);
                        over++;
                        playAudio(R.raw.error);
                    }
                    if (sequence[counter] == 2) {
                        playAudio(R.raw.yellow);
                        score++;
                    }
                    counter++;
                    if (score == 6 && over == 0) {
                        String yadiditson = "You got it all right!";
                        text.setText(yadiditson);
                        over++;
                    }
                } else
                    playAudio(R.raw.yellow);
            }
        });

        bluebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (over == 0) {
                    if (sequence[counter] != 3 && over == 0) {
                        String prompt;
                        for (int i = 0; i < 6; i++) {
                            if (sequence[i] == 0)
                                order = order + "red ";
                            if (sequence[i] == 1)
                                order = order + "green ";
                            if (sequence[i] == 2)
                                order = order + "yellow ";
                            if (sequence[i] == 3)
                                order = order + "blue ";
                        }

                        prompt = "You only got " + score + " right, the correct order was: " + order;
                        text.setText(prompt);
                        over++;
                        playAudio(R.raw.error);
                    }
                    if (sequence[counter] == 3) {
                        playAudio(R.raw.blue);;
                        score++;
                    }
                    counter++;
                    if (score == 6 && over == 0) {
                        String yadiditson = "You got it all right!";
                        text.setText(yadiditson);
                        over++;
                    }
                } else
                    playAudio(R.raw.blue);
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float[] scorearray;
                Bundle extras = getIntent().getExtras();
                scorearray = extras.getFloatArray("score");
                scorearray[3] = score;

                Intent i = new Intent(getApplicationContext(), scorepage.class);
                i.putExtra("score", scorearray);
                startActivity(i);
            }
        });
    }
}
