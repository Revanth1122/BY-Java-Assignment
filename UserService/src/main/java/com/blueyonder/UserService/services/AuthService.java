package com.blueyonder.UserService.services;

import org.springframework.http.ResponseEntity;

import com.blueyonder.UserService.entity.User;
import com.blueyonder.UserService.exceptions.UserNotFoundException;
import com.blueyonder.UserService.exceptions.UsernameAlreadyExistException;
import com.blueyonder.UserService.request.MessageResponse;

public interface AuthService {
	public ResponseEntity<MessageResponse> saveUser(User credentials) throws  UsernameAlreadyExistException ;
	public String generateToken(String username);
	public void validateT(String token);
}