package com.blueyonder.UserService.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;



@RestControllerAdvice
public class EcommerceExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public String handleUserNotFoundException() {
		return "User not exist";
	}
	
	@ExceptionHandler(PasswordMismatchException.class)
	public String handlePasswordMismatchException() {
		return "Password MisMatch";
	}
	@ExceptionHandler(ConstraintViolationException.class)
	public String handlingException() {
		return "please enter valid data..";
	}
}
