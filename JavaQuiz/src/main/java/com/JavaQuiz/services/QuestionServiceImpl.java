package com.JavaQuiz.services;

import com.JavaQuiz.Model.Question;
import com.JavaQuiz.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {


    private QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        super();
        this.questionRepository = questionRepository;
    }

    @Override
    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question findQuestionByquestionId(Long id) {
        return questionRepository.findByquestionId(id);
    }

    @Override
    public void deleteQuestionByquestionId(Long id) {
        questionRepository.deleteById(id);
        return;
    }

}