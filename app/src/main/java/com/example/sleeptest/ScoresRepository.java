package com.example.sleeptest;


import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ScoresRepository {
    private ScoresDao scoresDao;
    private LiveData<List<Scores>> allScores;

    public ScoresRepository(Application application){
        ScoresDatabase database = ScoresDatabase.getInstance(application);
        scoresDao = database.scoresDao();
        allScores = scoresDao.getAllScores();
    }

    public void insert(Scores score) {
        new InsertScoresAsyncTask(scoresDao).execute(score);
    }

    public void update (Scores score){
        new DeleteScoresAsyncTask(scoresDao).execute(score);
    }

    public void delete (Scores score){
        new UpdateScoresAsyncTask(scoresDao).execute(score);
    }

    public void deleteAllScores(){
        new DeleteAllScoresAsyncTask(scoresDao).execute();
    }

    public LiveData<List<Scores>> getAllScores(){
        return allScores;
    }

    //code to run in background, helps with stack management
    private static class InsertScoresAsyncTask extends AsyncTask<Scores,Void,Void> {
        private ScoresDao scoresDao;

        private InsertScoresAsyncTask(ScoresDao scoresDao){
            this.scoresDao=scoresDao;
        }
        @Override
        protected Void doInBackground(Scores... scores) {
            scoresDao.insert(scores[0]);
            return null;
        }
    }

    private static class UpdateScoresAsyncTask extends AsyncTask<Scores,Void,Void> {
        private ScoresDao scoresDao;

        private UpdateScoresAsyncTask(ScoresDao scoresDao){
            this.scoresDao=scoresDao;
        }
        @Override
        protected Void doInBackground(Scores... scores) {
            scoresDao.update(scores[0]);
            return null;
        }
    }

    private static class DeleteScoresAsyncTask extends AsyncTask<Scores,Void,Void> {
        private ScoresDao scoresDao;

        private DeleteScoresAsyncTask(ScoresDao scoresDao){
            this.scoresDao=scoresDao;
        }
        @Override
        protected Void doInBackground(Scores... scores) {
            scoresDao.delete(scores[0]);
            return null;
        }
    }

    private static class DeleteAllScoresAsyncTask extends AsyncTask<Void,Void,Void> {
        private ScoresDao scoresDao;

        private DeleteAllScoresAsyncTask(ScoresDao scoresDao){
            this.scoresDao=scoresDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            scoresDao.deleteAllScores();
            return null;
        }
    }
}