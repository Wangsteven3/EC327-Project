package com.example.sleeptest;


import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ScoresViewModel extends AndroidViewModel {
    private ScoresRepository repository;
    private LiveData<List<Scores>> allScores;

    public ScoresViewModel(@NonNull Application application){
        super(application);
        repository = new ScoresRepository(application);
        allScores = repository.getAllScores();
    }

    public void insert (Scores score) {
        repository.insert(score);
    }

    public void update (Scores score){
        repository.update(score);
    }

    public void delete(Scores score){
        repository.delete(score);
    }

    public void deleteAllScores(){
        repository.deleteAllScores();
    }

    public LiveData<List<Scores>> getAllScores() {
        return allScores;
    }
}
