package com.JavaQuiz.repository;

import com.JavaQuiz.Model.Questions;
import com.JavaQuiz.Model.Results;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface QuestionsRepository extends JpaRepository<Questions,Integer> {
}
