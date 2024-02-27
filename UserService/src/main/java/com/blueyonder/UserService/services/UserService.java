package com.blueyonder.UserService.services;

import java.util.List;

import com.blueyonder.UserService.entity.User;
import com.blueyonder.UserService.exceptions.PasswordMismatchException;
import com.blueyonder.UserService.exceptions.UserNotFoundException;
import com.blueyonder.UserService.model.Login;

public interface UserService {

	public User addUser(User user) throws PasswordMismatchException;

	public User getUserByName(String uname) throws UserNotFoundException;

	public String verifyUser(Login user) throws UserNotFoundException;

}
