package com.JavaQuiz.Model;


import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "results") //Entity annotation specifies that current class is an Entity and is mapped to a particular table in a DB
@Table
public class Results implements Serializable {//NOTE: When implementing quiz functionality, make sure that you need Serialization

    @Id //current annotation shows PK
    @GeneratedValue // DB configuration for the current field (serial)
    @Column(name = "score_id")
    private int id;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "user_id") //FK
    private int userId; //(references USER id)

    //    NOTE:Choose data type for DATE
    @Column (name = "date")
    private String date;

    @Column (name = "score")
    private int score;

    //DEFAULT CONSTRUCTOR
    public Results() {
    }

    public Results(int id, int score) {
        this.id = id;
        this.score = score;
    }

    //GETTER/SETTER
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
