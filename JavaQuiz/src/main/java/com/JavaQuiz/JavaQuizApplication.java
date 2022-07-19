package com.JavaQuiz;

import com.JavaQuiz.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class JavaQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaQuizApplication.class, args);
	}

}
