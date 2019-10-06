package com.carRentig.rentig.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.carRentig.rentig.exception.IllegalArgumentException;
import com.carRentig.rentig.exception.NotFoundException;
import com.carRentig.rentig.exception.NotYourCarException;
import com.carRentig.rentig.exception.ValidationException;

public class ControllerExceptionAdvicer {
	
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
	public Exception handlerNotFoundException(NotFoundException e) {
		return e;
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	@ExceptionHandler(ValidationException.class)
	public Exception handlerValidationException(ValidationException e) {
		return e;
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
	@ExceptionHandler(IllegalArgumentException.class)
	public Exception handlerIllegalArgumentException(IllegalArgumentException e) {
		return e;
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(NotYourCarException.class)
	public Exception handlerNotYourCarException(NotYourCarException e) {
		return e;
	}
}
