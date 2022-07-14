package com.JavaQuiz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller //Controller Annotation
public class QuizController {

    @RequestMapping(value = {"/quiz"}, method = RequestMethod.GET)
    public ModelAndView quiz(){ //ModelAndView in Spring -
        ModelAndView modelAndView = new ModelAndView(); //creating new ModelAndView instance
        modelAndView.setViewName("quiz");  // html resource file
        return modelAndView;

    }
}
