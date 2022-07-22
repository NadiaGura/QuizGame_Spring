package com.JavaQuiz.controller;

import com.JavaQuiz.Model.Question;
import com.JavaQuiz.Model.Results;
import com.JavaQuiz.Model.User;
import com.JavaQuiz.dto.AnswersDTO;
import com.JavaQuiz.repository.QuestionRepository;
import com.JavaQuiz.repository.ResultRepository;
import com.JavaQuiz.repository.UserRepository;
import com.JavaQuiz.services.Services;
import com.JavaQuiz.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller //Controller Annotation
public class QuizController {
//    private QuestionService questionService;
//
//    public QuizController(QuestionService questionService) {
//        super();
//        this.questionService = questionService;
//    }

    @Autowired
    private Services services;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ResultRepository resultRepository;
    @Autowired
    private QuestionRepository questionsRepository;

    //home page
    @GetMapping
    String getIndex (){ return services.isAuthenticated("index"); }

    @RequestMapping(value = {"/quiz"})
    public String showQuiz(@ModelAttribute AnswersDTO answersDto, Model model){
        List<Question> questions = questionsRepository.findAll();
        model.addAttribute("questions", questions);
//        resultRepository.save(results);
        model.addAttribute("answersDto", answersDto);
        return "quiz";
    }

    @PostMapping("/result")
    public String validateQuiz( @ModelAttribute AnswersDTO answersDto, Model model) {
        List<Question> questions = questionsRepository.findAll();
        int correct=0;
        int opted=0;
        String[] submittedAnswers = answersDto.getAnswers();
        for(int i=0; i<questions.size(); i++) {
            if(submittedAnswers[i] != null) {
                opted++;
                if(submittedAnswers[i].equalsIgnoreCase(questions.get(i).getOptionCorrect())) {
                    correct++;
                }
            }
        }
        double score = Utils.calculateNegativeMarks(opted, correct);
        Results results = new Results();
        model.addAttribute("score", score);
        return "result";
    }

    //profile page displays user quiz history and top quiz results
    @RequestMapping(value = "/profile",method = RequestMethod.GET )
    public String profile(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = new User();
        user = userRepository.findByName(name);
        int id = user.getId();
//        model.addAttribute("userResults",resultRepository.findByUserId(id));
        model.addAttribute("results",resultRepository.findAll());
        System.out.println(id);
        return "profile";
    }

    }




