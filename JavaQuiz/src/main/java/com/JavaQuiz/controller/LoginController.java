package com.JavaQuiz.controller;
import com.JavaQuiz.Model.User;
import com.JavaQuiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;


    @PostMapping("/save")
    public String registerUser(@RequestParam String username, @RequestParam String password,
                               @RequestParam String email){
        User user = new User(username, password, email);
        //before saving check if username and email are already taken.
        if ((userRepository.findByUsername(user.getUsername()) != null) ||
                (userRepository.findByEmail(user.getEmail()) != null)){
            throw new RuntimeException("username taken");
        }else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return "/register";
        }
    }


}
