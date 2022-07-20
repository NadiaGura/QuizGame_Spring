package com.JavaQuiz.controller;

import com.JavaQuiz.Model.User;
import com.JavaQuiz.services.Services;
import com.JavaQuiz.services.UserDetailsServiceImpl;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class ForgotPasswordController {
    @Autowired
    private UserDetailsServiceImpl userService;
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private Services services;

    @PostMapping("/forgotPassword")
    public String forgotPasswordFrom(HttpServletRequest request, Model model) {
        String token = RandomString.make(45);
        String email = request.getParameter("email");
        try {
            userService.updateResetPasswordToken(token, email);
            String resetPasswordLink = services.getUrl(request) + "/reset_password?token=" + token;
            sendEmail(email, resetPasswordLink);
        } catch (UsernameNotFoundException e) {
            model.addAttribute("error", e.getMessage());
        } catch (MessagingException | UnsupportedEncodingException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "/reset";
    }

    private void sendEmail(String email, String resetPasswordLink) throws UnsupportedEncodingException, MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom("javaQuiz@quiz.com", "Java Quiz");
        helper.setTo(email);
        String subject = "Change password";
        String content = "<p>Hello,</>"
                + "<p><a href=\"" + resetPasswordLink + "\">Click me to change password</a></p>"
                + "<p>Ignore this email if you have not made a request.</p>";
        helper.setSubject(subject);
        helper.setText(content, true);
        mailSender.send(message);
    }

    @GetMapping("/reset_password")
    public String showResetForm(@Param(value = "token") String token, Model model) {
        User user = userService.getToken(token);
        if (user == null) {
            model.addAttribute("message", "Invalid url");
            return "message";
        } else {
            model.addAttribute("token", token);
        }
        return "/changePassword";
    }

    @PostMapping("/changePassword")
    public String changePassword(@RequestParam String newPassword, @RequestParam String newPassword2,
                                 @RequestParam String token, Model model) {
        User user = userService.getToken(token);
        if ((!newPassword.equals(newPassword2)) || user == null) {
            model.addAttribute("error", "Error: Either wrong password values or form is inactive.");
            return "failure";
        } else {
            userService.updatePassword(user, newPassword);
            model.addAttribute("message", "Password changed successfully.");
            return "login";
        }
    }

}
