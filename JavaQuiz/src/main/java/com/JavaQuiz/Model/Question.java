package com.JavaQuiz.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Questions2")
public class Question{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long questionId;

    @Column(name = "question_title", nullable = false)
    private String title;

    public List<Answers> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answers> answers) {
        this.answers = answers;
    }

    @OneToMany(targetEntity= Answers.class, mappedBy="question", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Answers> answers; //value to text

    @Column(name = "option_correct", nullable = false)
    private String optionCorrect;

    private String optionChosen =null;

    public Question() {
    }

    public Question(String title, List<Answers> answers, String optionCorrect, String subject) {
        super();
        this.title = title;
        this.answers = answers;
        this.optionCorrect = optionCorrect;
    }

    public Long getQuestionId() {
        return questionId;
    }
    public void setQuestionId(Long id) {
        this.questionId = questionId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getOptionCorrect() {
        return optionCorrect;
    }

    public void setOptionCorrect(String optionCorrect) {
        this.optionCorrect = optionCorrect;
    }



}
