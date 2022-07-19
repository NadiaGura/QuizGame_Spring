package com.JavaQuiz.repository;

import com.JavaQuiz.Model.Results;
import com.JavaQuiz.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Results, Integer> {
    Results findByUserId (Integer userId);

}

