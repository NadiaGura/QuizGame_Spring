package com.JavaQuiz.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "questions") //Entity annotation specifies that current class is an Entity and is mapped to a particular table in a DB
@Table
public class Questions implements Serializable { //NOTE: When implementing quiz functionality, make sure that you need Serialization


    @Id //current annotation shows PK
    @GeneratedValue // DB configuration for the current field (serial)
    private int id;


    //creating columns in the table for question
    @Column
    private String question;


    //DEFAULT CONSTRUCTOR
    public Questions() {
    }

    public Questions(int id, String question) {
        this.id = id;
        this.question = question;
    }


//    private Set<AnswerEntity> answers; //Set as storing unique values not ordered
//    public Set<AnswerEntity>getAnswers(){
//        return answers;
//    }


    //GETTER/SETTER
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
