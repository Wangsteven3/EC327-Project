package com.example.sleeptest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class AddScoresActivity extends AppCompatActivity {
    public static final String EXTRA_DATE =
            "com.example.sleeptest.EXTRA_DATE";
    public static final String EXTRA_SCORES =
            "com.example.sleeptest.EXTRA_SCORES";

    private EditText editTextDate;
    private EditText editTextScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_scores);

        editTextDate = findViewById(R.id.edit_text_date);
        editTextScore = findViewById(R.id.edit_text_score);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Score");
    }

    private void saveScores(){
        String date = editTextDate.getText().toString();
        String scores = editTextScore.getText().toString();

        if (date.trim().isEmpty() || scores.trim().isEmpty()){
            Toast.makeText(this, "Please insert a Date and Score", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_DATE, date);
        data.putExtra(EXTRA_SCORES, scores);

        setResult(RESULT_OK,data);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_scores_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_scores:
                saveScores();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}