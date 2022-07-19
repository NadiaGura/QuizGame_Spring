package com.JavaQuiz;

import com.JavaQuiz.repository.UserRepository;
import com.JavaQuiz.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller //Controller Annotation
public class QuizController {

    @Autowired
    private Services services;

    @RequestMapping(value = {"/quiz"}, method = RequestMethod.GET)
    public ModelAndView quiz(){ //ModelAndView in Spring -
        ModelAndView modelAndView = new ModelAndView(); //creating new ModelAndView instance
        modelAndView.setViewName("quiz");  // html resource file
        return modelAndView;
    }
    @Autowired
    private UserRepository userRepository;

    //home page
    @GetMapping
    String getIndex (){
        return services.isAuthenticated("index");
    }

    // Login form
    @RequestMapping("/login")
    public String login() {
        return services.isAuthenticated("login");
    }

    // [password reset form
    @RequestMapping("/reset")
    public String resetPassword() {
        return services.isAuthenticated("reset");
    }
    // [password reset form
    @RequestMapping("/change")
    public String changePassword() {
        return services.isAuthenticated("changePassword");
    }


    @RequestMapping(value = "/profile",method = RequestMethod.GET )
    public String profile(Model model) {
        //model.addAttribute("user",userRepository.findAll());
        return "profile";
    }

    // quiz result page
    @RequestMapping("/result")
    public String result() {
        return "result";
    }
    }




