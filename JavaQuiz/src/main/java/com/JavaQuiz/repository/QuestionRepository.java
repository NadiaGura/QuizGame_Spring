package com.JavaQuiz.repository;

import com.JavaQuiz.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {
    Question findByquestionId(Long id);
    void deleteByquestionId(Long id);
}
