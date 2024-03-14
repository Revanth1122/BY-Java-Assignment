package com.blueyonder.UserService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blueyonder.UserService.entity.User;
import com.blueyonder.UserService.exceptions.UserNotFoundException;
import com.blueyonder.UserService.exceptions.UsernameAlreadyExistException;
import com.blueyonder.UserService.repository.UserRepository;
import com.blueyonder.UserService.request.MessageResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServicImpl implements AuthService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JWTService jwtService;
	
	

	@Override
	public String generateToken(String username) {
		return jwtService.generateToken(username);
	}

	@Override
	public void validateT(String token) {
		jwtService.validateToken(token);
		
	}

	@Override
	public ResponseEntity<MessageResponse> saveUser(User credentials) throws UsernameAlreadyExistException {
		  if (userRepository.existsByUsername(credentials.getUserName())) {
	            throw new UsernameAlreadyExistException("Error: Username is already taken!");
	        }
	        credentials.setPassword1(passwordEncoder.encode(credentials.getPassword1()));
	        userRepository.save(credentials);
	        return ResponseEntity.ok(new MessageResponse("User has been stored"));
	}

}