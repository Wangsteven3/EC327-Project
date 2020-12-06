package com.example.sleeptest;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Scores.class}, version = 1, exportSchema = false)
public abstract class ScoresDatabase extends RoomDatabase {

    private static ScoresDatabase instance;

    public abstract ScoresDao scoresDao();

    public static synchronized  ScoresDatabase getInstance(Context context){
        if (instance ==null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                        ScoresDatabase.class,"scores_database")
                        .fallbackToDestructiveMigration()
                        .build();
        }
        return instance;
    }
}
