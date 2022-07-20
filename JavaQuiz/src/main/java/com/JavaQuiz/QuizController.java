package com.JavaQuiz;

import com.JavaQuiz.Model.Question;
import com.JavaQuiz.Model.Results;
import com.JavaQuiz.Model.User;
import com.JavaQuiz.dto.AnswersDTO;
import com.JavaQuiz.repository.QuestionRepository;
import com.JavaQuiz.repository.ResultRepository;
import com.JavaQuiz.repository.UserRepository;
import com.JavaQuiz.services.QuestionService;
import com.JavaQuiz.services.Services;
import com.JavaQuiz.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@Controller //Controller Annotation
public class QuizController {
    private QuestionService questionService;

    public QuizController(QuestionService questionService) {
        super();
        this.questionService = questionService;
    }

    @Autowired
    private Services services;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ResultRepository resultRepository;
    @Autowired
    private QuestionRepository questionsRepository;

    @RequestMapping(value = {"/quiz"})
    public String showQuiz(Model model){
        List<Question> questions = questionsRepository.findAll();
//        Quiz quiz = new Quiz(subject, questions, session);
//        session.setQuiz(quiz);
//        session.setScore(0);
//        ContextController.getStudent().setSession(session);
//        session.setStudentId(ContextController.getStudent().getId());
//        session.setStudentName(ContextController.getStudent().getUsername());
//        ContextController.setSession(session); //optional shared context
//        sessionService.saveSession(session);
//        ContextController.questions = questions;
        model.addAttribute("questions", questions);
        AnswersDTO answersDto = new AnswersDTO();
        model.addAttribute("answersDto", answersDto);
//        model.addAttribute("student", ContextController.getStudent());
        return "quiz";
    }

    @PostMapping("/submit")
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
        System.out.println(score);
        model.addAttribute("score", score);
        return "result";
    }


    //home page
    @GetMapping
    String getIndex (){ return services.isAuthenticated("index"); }

    // Login form
    @RequestMapping("/login")
    public String login() {
        return "login";
    }


    // [password reset form
    @RequestMapping("/reset")
    public String resetPassword() {
        return "reset";
    }
    // [password reset form
    @RequestMapping("/change")
    public String changePassword() {
        return "changePassword";
    }

    @RequestMapping(value = "/profile",method = RequestMethod.GET )
    public String profile(Model model) {
        Results results = new Results();
        User user = new User();
        String userName= user.getName();
        int id = results.getUserId();
        model.addAttribute("userResults",resultRepository.findByUserId(id));
        model.addAttribute("results",resultRepository.findAll());
//        model.addAttribute("user", userRepository.findByName(userName));
        return "profile";
    }

    // quiz result page
    @RequestMapping("/result")
    public String result(Model model) {
        return "result";
    }
    }




