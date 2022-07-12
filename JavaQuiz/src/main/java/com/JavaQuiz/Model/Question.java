package com.JavaQuiz.Model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

//@Entity(name = "questions") //Entity annotation specifies that current class is an Entity and is mapped to a particular table in a DB
public class Question implements Serializable { //NOTE: When implementing quiz functionality, make sure that you need Serialization


    @Id //current annotation shows PK
    @GeneratedValue // DB configuration for the current field (serial)
    private int id;


    //creating columns in the table for question
    @Column
    private String questionContent;


    //DEFAULT CONSTRUCTOR
    public Question() {
    }

    public Question(int id, String questionContent) {
        this.id = id;
        this.questionContent = questionContent;
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

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }
}
