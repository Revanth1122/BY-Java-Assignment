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
import com.blueyonder.UserService.model.Login;
import com.blueyonder.UserService.services.UserService;



@RestController
@CrossOrigin("*")
@RequestMapping("/ecommerce/api/v1/user")
public class UserController {

	@Autowired
	private UserService userservice;

	@PostMapping("/registeration")
	public ResponseEntity<User> addUser(@RequestBody User user) throws PasswordMismatchException {
		if (user.getPassword1().equals(user.getPassword2())) {
			User usr =  userservice.addUser(user);
			return new ResponseEntity<User>(usr,HttpStatus.OK);
			
		} else {
			throw new PasswordMismatchException();
		}
	}

//	public User getUserByName(String uname) throws UserNotFoundException ;

	@PostMapping("/login")
	public String verifyUser(@RequestBody Login user) throws UserNotFoundException {
		return userservice.verifyUser(user);
	}

}
