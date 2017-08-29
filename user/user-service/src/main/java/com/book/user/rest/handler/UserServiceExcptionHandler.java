package com.book.user.rest.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.book.common.dto.ErrorDTO;
import com.book.common.excption.RunException;
import com.book.user.rest.UserController;

@ControllerAdvice(assignableTypes = UserController.class)
public class UserServiceExcptionHandler {
	@ExceptionHandler(RunException.class)
	public ErrorDTO onUserservice(RunException ex) {
		return new ErrorDTO(ex);
	}
}
