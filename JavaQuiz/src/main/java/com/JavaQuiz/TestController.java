package com.JavaQuiz;

import com.JavaQuiz.Model.UserRepository;
import com.JavaQuiz.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    private UserRepository userRepository;

    //home page
    @GetMapping
    String getIndex (){
        return "index";
    }
    //test connection
    @GetMapping ("/conn")
    public @ResponseBody
    Iterable<User> getConnection (){
        return userRepository.findAll();
    }


    // Login form
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    // registration form
    @RequestMapping("/register")
    public String register() {
        return "register";
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

    // [password reset form
    @RequestMapping("/quiz")
    public String quiz() {
        return "quiz";
    }
    // user profile page
    @RequestMapping("/profile")
    public String profile() {
        return "profile";
    }

    // quiz result page
    @RequestMapping("/result")
    public String result() {
        return "result";
    }



}
