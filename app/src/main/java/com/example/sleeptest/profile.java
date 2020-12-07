package com.example.sleeptest;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class profile extends AppCompatActivity {
    public static final int ADD_SCORES_REQUEST = 1;

    private ScoresViewModel scoresViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //profile xml

        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile); //profile xml

        FloatingActionButton buttonAddScores = findViewById(R.id.button_add_scores);
        buttonAddScores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profile.this, AddScoresActivity.class);
                startActivityForResult(intent,ADD_SCORES_REQUEST);
            }
        });


        RecyclerView recyclerView = findViewById(R.id.inputstuff);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final ScoresAdapter adapter = new ScoresAdapter();
        recyclerView.setAdapter(adapter);

        scoresViewModel = ViewModelProviders.of(this).get(ScoresViewModel.class);
        scoresViewModel.getAllScores().observe(this, new Observer<List<Scores>>() {
            @Override
            public void onChanged(List<Scores> scores) {
                adapter.setScores(scores);
            }
        });
    }

    public void MenuClick(View v) { //button click listener for profile page menu button

        if (v.getId() == R.id.Bmenu) {

            Intent i = new Intent(profile.this, MainActivity.class);
            startActivity(i);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_SCORES_REQUEST && resultCode == RESULT_OK){
            String date = data.getStringExtra(AddScoresActivity.EXTRA_DATE);
            String scores = data.getStringExtra(AddScoresActivity.EXTRA_SCORES);

            Scores score = new Scores(date,scores);
            scoresViewModel.insert(score);

            Toast.makeText(this, "Score saved", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, "Score score saved", Toast.LENGTH_SHORT).show();
        }
    }
}
