//package com.JavaQuiz.Model;
//
//import javax.persistence.*;
//import java.util.List;
//@Entity
//@Table(name = "Quizes")
//public class Quiz {
//
//    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
//    private Long quizId;
//
//    @Column(name = "subject")
//    private String subject;
//
//    @OneToMany(targetEntity=Question.class, mappedBy = "quiz", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private List<Question> questions;
//
//    public Quiz() {
//
//    }
//
//    public Quiz(String subject, List<Question> questions) {
//        super();
//        this.subject = subject;
//        this.questions = questions;
//    }
//
//    public Long getQuizId() {
//        return quizId;
//    }
//
//    public void setQuizId(Long quizId) {
//        this.quizId = quizId;
//    }
//
//    public String getSubject() {
//        return subject;
//    }
//
//    public void setSubject(String subject) {
//        this.subject = subject;
//    }
//
//    public List<Question> getQuestions() {
//        return questions;
//    }
//
//    public void setQuestions(List<Question> questions) {
//        this.questions = questions;
//    }
//}