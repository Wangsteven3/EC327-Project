package com.example.sleeptest;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
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

        scoresViewModel = ViewModelProvider.of(this).get(ScoresViewModel.class);
        scoresViewModel.getAllScores().observe(this, new Observer<List<Scores>>() {
            @Override
            public void onChanged(List<Scores> scores) {
                adapter.setScores(scores);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                scoresViewModel.delete(adapter.getScoreAt(viewHolder.getAdapterPosition()));
                Toast.makeText(profile.this,"Score Deleted", Toast.LENGTH_SHORT);
            }
        }).attachToRecyclerView(recyclerView);
    }

    public void MenuClick(View v) { //button click listener for profile page menu button

        if (v.getId() == R.id.Bmenu) {

            Intent i = new Intent(profile.this, MainActivity.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_left, R.anim.slide_left); //set animation when activity starts
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
            Toast.makeText(this, "Score not saved", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.profile_menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.delete_all_scores:
                scoresViewModel.deleteAllScores();
                Toast.makeText(this,"All scores deleted",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
