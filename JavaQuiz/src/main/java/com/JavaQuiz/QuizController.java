package com.JavaQuiz;

import com.JavaQuiz.Model.Questions;
import com.JavaQuiz.Model.Results;
import com.JavaQuiz.repository.QuestionsRepository;
import com.JavaQuiz.repository.ResultRepository;
import com.JavaQuiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller //Controller Annotation
public class QuizController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ResultRepository resultRepository;
//    @Autowired
//    private QuestionsRepository questionsRepository;

    @RequestMapping(value = {"/quiz"}, method = RequestMethod.GET)
    public ModelAndView quiz(){ //ModelAndView in Spring -
        ModelAndView modelAndView = new ModelAndView(); //creating new ModelAndView instance
        modelAndView.setViewName("quiz");  // html resource file
        return modelAndView;
    }

//    @RequestMapping ("/quiz")
//    public String showQuiz (@PathVariable Integer id, Model model){
//        List<Questions> questions = questionsRepository.findByQuestionId(id);
//        return "quiz";
//    }

    //home page
    @GetMapping
    String getIndex (){
        return "index";
    }

    // Login form
    @RequestMapping("/login")
    public String login() {
        return "login";
    }


    // password reset form
    @RequestMapping("/reset")
    public String resetPassword() {
        return "reset";
    }
    // [password reset form
    @RequestMapping("/change")
    public String changePassword() {
        return "changePassword";
    }

//need tu add username to be displayed in profile page!!!
    @RequestMapping(value = "/profile/{id}",method = RequestMethod.GET )
    public String profile(@PathVariable Integer id, Model model) {
        model.addAttribute("userResults",resultRepository.findByUserId(id));
        model.addAttribute("results",resultRepository.findAll());
        return "profile";
    }

    // quiz result page
    @RequestMapping("/result")
    public String result() {
        return "result";
    }
    }




