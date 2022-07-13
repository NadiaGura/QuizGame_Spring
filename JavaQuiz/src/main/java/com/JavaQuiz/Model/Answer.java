package com.JavaQuiz.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

//Entity annotation specifies that current class is an Entity and is mapped to a particular table in a DB
@Entity
public class Answer implements Serializable { //NOTE: Please check whether Serialization will be applicable when making an integration

    @Id //current annotation shows PK
    @GeneratedValue // DB configuration for the current field (serial)
    private int id;

    @Column
    private String answerText;
    @Column
    private boolean answerStatus;
    //@Column FK
    // private int question_Id; (references QUESTION id)


    //DEFAULT CONSTRUCTOR
    public Answer() {
    }

    public Answer(int id, String answerText, boolean answerStatus) {
        this.id = id;
        this.answerText = answerText;
        this.answerStatus=answerStatus;
    }


    //GETTER/SETTER
    public int getId() {
        return id;
    }
    public String getAnswerText() {
        return answerText;
    }
    public boolean getAnswerStatus() {
        return answerStatus;
    }



    public void setId(int id) {
        this.id = id;
    }
    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }
    public void setAnswerStatus(boolean answerStatus) {
        this.answerStatus = answerStatus;
    }

}
