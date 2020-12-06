package com.example.sleeptest;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Scores.class}, version = 1, exportSchema = false)
public abstract class ScoresDatabase extends RoomDatabase {

    private static ScoresDatabase instance;

    public abstract ScoresDao scoresDao();

    public static synchronized  ScoresDatabase getInstance(Context context){
        if (instance ==null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                        ScoresDatabase.class,"scores_database")
                        .fallbackToDestructiveMigration()
                        .addCallback(roomCallback)
                        .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void> {
        private ScoresDao scoresDao;

        private PopulateDbAsyncTask(ScoresDatabase db){
            scoresDao = db.scoresDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            scoresDao.insert(new Scores("12/05/2020",1, 2,3,4) );
            return null;
        }
    }
}
