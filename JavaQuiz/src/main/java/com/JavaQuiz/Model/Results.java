package com.JavaQuiz.Model;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

//@Entity(name = "results") //Entity annotation specifies that current class is an Entity and is mapped to a particular table in a DB
//@Table
public class Results implements Serializable {//NOTE: When implementing quiz functionality, make sure that you need Serialization

    @Id //current annotation shows PK
    @GeneratedValue // DB configuration for the current field (serial)
    private int id;

    //@Column(name = "user_id") //FK
    //private int userId; (references USER id)

    //NOTE:Choose data type for DATE
    //@Column
    //private String date;

    @Column
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
}
