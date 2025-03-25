package com.mph.demosprboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mph.demosprboot.entity.User;
import com.mph.demosprboot.service.UserService;

@RestController
@RequestMapping("/demosprboot/api/auth")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders = "*",methods= {RequestMethod.GET,
		RequestMethod.POST,RequestMethod.DELETE,RequestMethod.OPTIONS},allowCredentials = "true")
public class UserController {
	@Autowired
	private UserService authService;
	@PostMapping("/register")
	public ResponseEntity<?>registerUser(@RequestBody User user){
			
		String response=authService.registerUser(user);
		if(response.equals("Username already exists")) {
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok((response));
	}
	@PostMapping("/login")
	public ResponseEntity<?>loginUser(@RequestBody User user){
	
		User authenticatedUser =authService.authenticateUser(user);
		if(authenticatedUser !=null) {
			return ResponseEntity.ok(authenticatedUser);
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
	}
}
