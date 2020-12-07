package com.example.sleeptest;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "score_table")
public class Scores {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "date_time")
    private String dateTime;
    @ColumnInfo(name = "Total Score")
    private String totalScore;

    public Scores(String dateTime, String totalScore) {
        this.dateTime = dateTime;
        this.totalScore = totalScore;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateTime(String dateTime) { this.dateTime = dateTime; }
    public void setTotalScore(String totalScore) { this.totalScore = totalScore; }

    public int getId() { return id; }
    public String getDateTime() { return this.dateTime; }
    public String getTotalScore() { return this.totalScore; }

}
