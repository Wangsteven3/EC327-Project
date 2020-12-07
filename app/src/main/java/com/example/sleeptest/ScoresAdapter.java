package com.example.sleeptest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ScoresAdapter extends RecyclerView.Adapter<ScoresAdapter.ScoresHolder> {
    private List<Scores> scores = new ArrayList<>();

    @NonNull
    @Override
    public ScoresHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.scores_item, parent,false);
        return new ScoresHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ScoresHolder holder, int position) {
        Scores currentScore = scores.get(position);
        holder.textViewDate.setText(currentScore.getDateTime());
        holder.textViewScore.setText(String.valueOf(currentScore.getTotalScore()));
    }

    @Override
    public int getItemCount() {
        return scores.size();
    }

    public void setScores(List<Scores> scores){
        this.scores = scores;
        notifyDataSetChanged();
    }

    public Scores getScoreAt(int position){
        return scores.get(position);
    }

    class ScoresHolder extends RecyclerView.ViewHolder{
        private TextView textViewDate;
        private TextView textViewScore;

        public ScoresHolder(@NonNull View itemView) {
            super(itemView);
            textViewDate = itemView.findViewById(R.id.test_view_date);
            textViewScore = itemView.findViewById(R.id.test_view_totalScore);
        }
    }
}
