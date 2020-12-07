package com.example.sleeptest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class profile extends AppCompatActivity {
    private ScoresViewModel scoresViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //profile xml
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile); //profile xml

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
}
