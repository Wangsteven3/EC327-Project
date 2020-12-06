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
    private int totalScore;

    @ColumnInfo(name = "Memory Score")
    private int memScore;
    @ColumnInfo(name = "Simon Score")
    private int simonScore;
    @ColumnInfo(name = "Math Score")
    private int mathScore;

    public Scores(String dateTime, int totalScore, int memScore, int simonScore, int mathScore) {
        this.dateTime = dateTime;
        this.totalScore = totalScore;
        this.memScore = memScore;
        this.simonScore = simonScore;
        this.mathScore = mathScore;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateTime(String dateTime) { this.dateTime = dateTime; }
    public void setTotalScore(int totalScore) { this.totalScore = totalScore; }

    public void setMemScore(int memScore) { this.memScore = memScore; }
    public void setSimonScore(int simonScore) { this.simonScore = simonScore; }
    public void setMathScore(int mathScore) { this.mathScore = mathScore; }


    public int getId() { return id; }

    public String getDateTime() { return dateTime; }
    public int getTotalScore() { return totalScore; }

    public int getMemScore() { return memScore; }
    public int getSimonScore() { return simonScore; }
    public int getMathScore() { return mathScore; }
}
