package com.JavaQuiz.services;

import com.JavaQuiz.Model.Question;

import java.util.List;

public interface QuestionService {

    Question saveQuestion(Question question);

    Question findQuestionByquestionId(Long id);

    void deleteQuestionByquestionId(Long id);
}

