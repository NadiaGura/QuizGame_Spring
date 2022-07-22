package com.JavaQuiz.controller;
import com.JavaQuiz.Model.User;
import com.JavaQuiz.repository.UserRepository;
import com.JavaQuiz.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.crypto.password.PasswordEncoder;

@Controller
public class LoginController {

    @Autowired
    // needed to use method that checks if user is logged in.
    private Services services;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    // registration form
    @RequestMapping("/register")
    public String register() {
        return services.isAuthenticated("register");
    }

    @PostMapping("/save")
    public String registerUser(@RequestParam String name, @RequestParam String password,
                               @RequestParam String email, Model model){
        User user = new User(name, password, email);
        //before saving check if username and email are already taken.
        if ((userRepository.findByName(user.getName()) != null) ||
                (userRepository.findByEmail(user.getEmail()) != null)){
            model.addAttribute("error", new Exception());
            return "/register";
        }else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return "/registrationSuccessful";
        }
    }
    @RequestMapping(value = "/registrationSuccessful")
    public String registerDone() {
        return "profile";
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
}
