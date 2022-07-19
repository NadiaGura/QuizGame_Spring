package com.JavaQuiz.repository;

import com.JavaQuiz.Model.Questions;
import com.JavaQuiz.Model.Results;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionsRepository extends JpaRepository<Questions, Integer> {
//    List<Questions> findByQuestionId (Integer id);
}
