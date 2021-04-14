package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.exceptions.BadLocationException;
import com.example.demo.exceptions.InvalideAgeException;
import com.example.demo.repositories.UserRepository;

@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@GetMapping("/users")
	public List<User> users(){
		return userRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User getOne(@PathVariable Long id) {
		return userRepository.findById(id).get();
	}
	
	@PostMapping("/users")
	@ResponseStatus()
	public User save(@RequestBody User user) throws BadLocationException, InvalideAgeException{
		return userRepository.save(user);
		
	}
	@PutMapping("/users/{id}")
	public User update(@RequestBody User user, @PathVariable Long id){
		user.setId(id);
		return userRepository.save(user);
	}
	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable Long id) {
		userRepository.deleteById(id);
	}
}
