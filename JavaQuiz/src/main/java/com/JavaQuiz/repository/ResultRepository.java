package com.JavaQuiz.repository;

import com.JavaQuiz.Model.Results;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<Results, Integer> {
    Results findByUserId (Integer userId);
}

