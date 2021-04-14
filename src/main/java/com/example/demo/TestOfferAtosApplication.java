package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.User;
import com.example.demo.exceptions.BadLocationException;
import com.example.demo.exceptions.InvalideAgeException;
import com.example.demo.repositories.UserRepository;

@SpringBootApplication
public class TestOfferAtosApplication {
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(TestOfferAtosApplication.class, args);
		
		
		User user1= null;
		try {
			user1 = new User(null,"yoyo","yaya","yiyi","19/01/2010","maroc");
		}catch(InvalideAgeException|BadLocationException f) {
			System.out.println(f);
		}
		
	}

}
