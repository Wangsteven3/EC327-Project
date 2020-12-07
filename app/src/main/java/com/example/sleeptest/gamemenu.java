package com.example.sleeptest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class gamemenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) { //activity_main xml (home page)
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamemenu);

        Button memorytwo = (Button) findViewById(R.id.choice2);
        Button Simon = (Button) findViewById(R.id.choice1);
        Button memorythree = (Button) findViewById(R.id.choice3);
        Button memoryfour = (Button) findViewById(R.id.choice4);
<<<<<<< Updated upstream
        Button math = (Button) findViewById(R.id.choice5);
=======
        Button Math = (Button) findViewById(R.id.button19);
>>>>>>> Stashed changes

        memorytwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(gamemenu.this, memory2.class);
                startActivity(i);
            }
        });

        Simon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(gamemenu.this, Simon.class);
                startActivity(i);
            }
        });

        memorythree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(gamemenu.this, memory3.class);
                startActivity(i);
            }
        });

        memoryfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(gamemenu.this, memory4.class);
                startActivity(i);
            }
        });

<<<<<<< Updated upstream
        math.setOnClickListener(new View.OnClickListener() {
=======
        Math.setOnClickListener(new View.OnClickListener() {
>>>>>>> Stashed changes
            @Override
            public void onClick(View v) {
                Intent i = new Intent(gamemenu.this, Math.class);
                startActivity(i);
            }
        });
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes


    }



}

