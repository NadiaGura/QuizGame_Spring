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
    private String questionA;
    @Column
    private String questionB;
    @Column
    private String questionC;
    @Column
    private String questionD;

    //DEFAULT CONSTRUCTOR
    public Answer() {
    }

    public Answer(int id, String questionA, String questionB, String questionC, String questionD) {
        this.id = id;
        this.questionA = questionA;
        this.questionB = questionB;
        this.questionC = questionC;
        this.questionD = questionD;
    }


    //GETTER/SETTER
    public int getId() {
        return id;
    }

    public String getQuiestionA() {
        return questionA;
    }

    public String getQuiestionB() {
        return questionB;
    }

    public String getQuiestionC() {
        return questionC;
    }

    public String getQuiestionD() {
        return questionD;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuiestionA(String quiestionA) {
        this.questionA = quiestionA;
    }

    public void setQuiestionB(String quiestionB) {
        this.questionB = quiestionB;
    }

    public void setQuiestionC(String quiestionC) {
        this.questionC = quiestionC;
    }

    public void setQuiestionD(String quiestionD) {
        this.questionD = quiestionD;
    }
}
