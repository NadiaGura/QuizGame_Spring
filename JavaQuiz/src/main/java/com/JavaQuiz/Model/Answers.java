package com.JavaQuiz.Model;

import javax.persistence.*;
@Entity
@Table(name = "options")
public class Answers {

        @javax.persistence.Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long Id;
        private String optionText;

        @ManyToOne()
        @JoinColumn(name="question_id")
        private Question question;

        public Answers() {
        }
        public Answers(String optionText) {
            super();
            this.optionText = optionText;
        }

        public Long getId() {
            return Id;
        }
        public void setId(Long id) {
            Id = id;
        }
        public String getOptionText() {
            return optionText;
        }
        public void setOptionText(String optionText) {
            this.optionText = optionText;
        }
        public Question getQuestion() {
            return question;
        }
        public void setQuestion(Question question) {
            this.question = question;
        }

    }
