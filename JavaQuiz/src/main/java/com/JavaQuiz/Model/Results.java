package com.JavaQuiz.Model;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity(name = "results") //Entity annotation specifies that current class is an Entity and is mapped to a particular table in a DB
@Table
public class Results implements Serializable {//NOTE: When implementing quiz functionality, make sure that you need Serialization

    @Id //current annotation shows PK
    @GeneratedValue(strategy = GenerationType.AUTO) // DB configuration for the current field (serial)
    private int scoreId;

    @Column(name = "user_id") //FK
    private int userId; //(references USER id)

    //NOTE:Choose data type for DATE, ensure that data type is working as expected
    @Column
    private String date;

    @Column
    private int score;

    //DEFAULT CONSTRUCTOR
    public Results() {
    }

    public Results(int scoreId,int userId, String date, int score) {
        this.scoreId = scoreId;
        this.userId=userId;
        this.date=date;
        this.score = score;
    }


    //GETTER/SETTER
    public int getScoreId() {
        return scoreId;
    }

    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {this.userId = userId;}

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
