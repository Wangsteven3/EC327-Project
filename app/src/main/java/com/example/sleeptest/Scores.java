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
    @ColumnInfo(name = "memory_score")
    private int memoryScore;
    @ColumnInfo(name = "simon_score")
    private int simonScore;
    @ColumnInfo(name = "math_score")
    private int mathScore;

    public Scores(String dateTime, int memoryScore, int simonScore, int mathScore) {
        this.dateTime = dateTime;
        this.memoryScore = memoryScore;
        this.simonScore = simonScore;
        this.mathScore = mathScore;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateTime(String dateTime) { this.dateTime = dateTime; }
    public void setMemoryScore(int memoryScore) { this.memoryScore = memoryScore; }
    public void setSimonScore(int simonScore) { this.simonScore = simonScore; }
    public void setMathScore(int mathScore) {this.mathScore = mathScore;}


    public int getId() { return id; }
    public String getDateTime() { return dateTime; }
    public int getMemoryScore() { return memoryScore; }
    public int getSimonScore() { return simonScore; }
    public int getMathScore() { return mathScore; }
}
