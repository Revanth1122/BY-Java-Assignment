package com.blueyonder.UserService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blueyonder.UserService.entity.User;
import com.blueyonder.UserService.exceptions.PasswordMismatchException;
import com.blueyonder.UserService.exceptions.UserNotFoundException;
import com.blueyonder.UserService.exceptions.UsernameAlreadyExistException;
import com.blueyonder.UserService.model.Login;
import com.blueyonder.UserService.request.LoginRequest;
import com.blueyonder.UserService.request.MessageResponse;
import com.blueyonder.UserService.services.AuthService;
import com.blueyonder.UserService.services.UserService;
import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/auth")
public class UserController {
	@Autowired
	private AuthService authService;
	
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@GetMapping("/hello")
	public String hello() {
		return "hello world";
	}
	
	@PostMapping("/register")
	public ResponseEntity<MessageResponse> addNewUser(@RequestBody User user) throws UsernameAlreadyExistException {
		
		return authService.saveUser(user);
	}
	@GetMapping("/validate")
	public String validateToken(@RequestParam(name="token")String token){
		return "Token is valid";
	}
	@PostMapping(value="/login",consumes =MediaType.ALL_VALUE)
	public String userLogin(@RequestBody LoginRequest userCredentials) {
		System.out.println(userCredentials);
		try {
			Authentication authenticate= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userCredentials.getUsername(), userCredentials.getPassword()));
			if(authenticate.isAuthenticated()) {
				SecurityContextHolder.getContext().setAuthentication(authenticate);
				String jwt = authService.generateToken(userCredentials.getUsername());
				
				UserService userDetails = (UserService) authenticate.getPrincipal();		
				
				
				
				return jwt;
			}
		} catch (Exception e) {
			return "Invalid Access";
		}
		return null;
		
	

	}
}