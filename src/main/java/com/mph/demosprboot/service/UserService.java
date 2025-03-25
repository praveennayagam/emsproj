package com.mph.demosprboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mph.demosprboot.entity.User;
import com.mph.demosprboot.repository.UserRepository;

@Service
public class UserService {
	@Autowired	
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public String registerUser(User user) {
		if(userRepository.findByUsername(user.getUsername()).isPresent()) {
			return "Username already exists";
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return "User registered successfully";
	}
	
	public User authenticateUser(User user) {
		Optional <User> existingUser = userRepository.findByUsername(user.getUsername());
		if(existingUser.isPresent() && passwordEncoder.matches(user.getPassword(),existingUser.get().getPassword())) {
			return existingUser.get();
		}
		return null;
	}
		
	}

