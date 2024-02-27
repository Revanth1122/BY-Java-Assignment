package com.blueyonder.UserService.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blueyonder.UserService.entity.User;
import com.blueyonder.UserService.exceptions.UserNotFoundException;
import com.blueyonder.UserService.model.Login;
import com.blueyonder.UserService.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
		
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userrepo;

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		logger.info("user added successfully..");
		return userrepo.save(user);
	}

	@Override
	public User getUserByName(String uname) throws UserNotFoundException {
		// TODO Auto-generated method stub
		logger.info("user found successfully..");
		return userrepo.findUserByName(uname);
	}

	@Override
	public String verifyUser(Login user) throws UserNotFoundException {
		User usr = userrepo.findUserByName(user.getUserName());
		if(usr!=null) {
			if(usr.getPassword1().equals(user.getPassword())){
				
				logger.info("user loggedin successfully..");
				return "LoggedIn Successfully...";
			}else {
				logger.debug("user with UserName"+user.getUserName()+" doesn't exist..");
				throw new UserNotFoundException();
			}
			
		}else {
			logger.debug("user with UserName"+user.getUserName()+" doesn't exist..");
			throw new UserNotFoundException();
		}
		

		

	}

}
