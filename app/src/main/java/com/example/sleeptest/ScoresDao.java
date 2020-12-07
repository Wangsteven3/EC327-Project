package com.example.sleeptest;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface ScoresDao {

    @Insert
    void insert(Scores score);

    @Update
    void update(Scores score);

    @Delete
    void delete(Scores score);

    @Query("DELETE FROM score_table")
    void deleteAllScores();

    @Query("SELECT * FROM score_table")
    LiveData<List<Scores>> getAllScores();
}
