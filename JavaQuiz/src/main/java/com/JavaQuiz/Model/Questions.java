package com.JavaQuiz.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "questions") //Entity annotation specifies that current class is an Entity and is mapped to a particular table in a DB
@Table
public class Questions implements Serializable { //NOTE: When implementing quiz functionality, make sure that you need Serialization


    @Id //current annotation shows PK
    @GeneratedValue // DB configuration for the current field (serial)
    @Column(name = "id")
    private int id;

    //creating columns in the table for question
    @Column(name = "question")
    private String question;

    @Column(name = "answer_A")
    private String questionA;

    @Column(name = "answer_B")
    private String questionB;

    @Column(name = "answer_C")
    private String questionC;

    @Column(name = "answer_D")
    private String questionD;

    @Column(name = "correct")
    private String correct;

//    @Column(name = "score_id")?? do wee need it in db or only here
//    private String answerChosen;

    //DEFAULT CONSTRUCTOR
    public Questions() {
    }

    public Questions(int id, String question, String questionA, String questionB, String questionC, String questionD, String correct) {
        this.id = id;
        this.question = question;
        this.questionA = questionA;
        this.questionB=questionB;
        this.questionC=questionC;
        this.questionD=questionD;
        this.correct=correct;
    }


//    private Set<AnswerEntity> answers; //Set as storing unique values not ordered
//    public Set<AnswerEntity>getAnswers(){
//        return answers;
//    }


    //GETTER/SETTER
    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getQuestionA() {
        return questionA;
    }

    public String getQuestionB() {
        return questionB;
    }

    public String getQuestionC() {
        return questionC;
    }

    public String getQuestionD() {
        return questionD;
    }

    public String getCorrect() {
        return correct;
    }

//    public String getAnswerChosen() {
//        return answerChosen;
//    }
    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setQuestionA(String questionA) {
        this.questionA = questionA;
    }

    public void setQuestionB(String questionB) {
        this.questionB = questionB;
    }

    public void setQuestionC(String questionC) {
        this.questionC = questionC;
    }

    public void setQuestionD(String questionD) {
        this.questionD = questionD;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

//    public void setAnswerChosen(String answerChosen) {
//        this.answerChosen = answerChosen;
//    }
}
