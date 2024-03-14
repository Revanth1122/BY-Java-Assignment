package com.blueyonder.UserService.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.blueyonder.UserService.entity.User;
import com.blueyonder.UserService.repository.UserRepository;



@Component
public class UserServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> userCredential= userRepository.findUserByName(username);
		return userCredential.map(UserService::new).orElseThrow(()->new UsernameNotFoundException("User not found with name :"+username));
	}

}