package com.book.book.rest.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.book.book.rest.BookController;
import com.book.common.dto.ErrorDTO;
import com.book.common.excption.RunException;

@ControllerAdvice(assignableTypes = BookController.class)
@RestController
public class BookControllerExcptionHandler {

	@ExceptionHandler(RunException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorDTO onUserservice(RunException ex) {
		return new ErrorDTO(ex);
	}
}
