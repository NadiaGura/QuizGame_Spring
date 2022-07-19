package com.JavaQuiz;

import com.JavaQuiz.Model.Results;
import com.JavaQuiz.Model.User;
import com.JavaQuiz.repository.ResultRepository;
import com.JavaQuiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller //Controller Annotation
public class QuizController {

    @RequestMapping(value = {"/quiz"}, method = RequestMethod.GET)
    public ModelAndView quiz(){ //ModelAndView in Spring -
        ModelAndView modelAndView = new ModelAndView(); //creating new ModelAndView instance
        modelAndView.setViewName("quiz");  // html resource file
        return modelAndView;
    }
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ResultRepository resultRepository;

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
    public String result() {
        return "result";
    }
    }




