package br.com.ricardoludwig.user.rest;

import java.util.Date;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.ricardoludwig.user.model.exception.InvalidUserException;
import br.com.ricardoludwig.user.repository.exception.UserAlreadyExistException;
import br.com.ricardoludwig.user.repository.exception.UserNotFoundException;

@ControllerAdvice(basePackageClasses = Controller.class)
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

	@ResponseBody
	@ExceptionHandler(InvalidUserException.class)
	ResponseEntity<?> handleInvalidEmailException(WebRequest request, InvalidUserException ex) {
		ResponseHandler respEx = new ResponseHandler(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(respEx, HttpStatus.BAD_REQUEST);
	}
	
	@ResponseBody
	@ExceptionHandler(UserNotFoundException.class)
	ResponseEntity<?> handleCustomerNotFoundException(WebRequest request, UserNotFoundException ex) {
		ResponseHandler respEx = new ResponseHandler(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(respEx, HttpStatus.NOT_FOUND);
	}
	
	@ResponseBody
	@ExceptionHandler(UserAlreadyExistException.class)
	ResponseEntity<?> handleCustomerAlreadyExistFoundException(WebRequest request, UserAlreadyExistException ex) {
		ResponseHandler respEx = new ResponseHandler(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(respEx, HttpStatus.CONFLICT);
	}
	
	class ResponseHandler {

		private final Date timestamp;
		private final String message;
		private final String details;

		ResponseHandler(Date timestamp, String message, String details) {
			super();
			this.timestamp = timestamp;
			this.message = message;
			this.details = details;
		}

		public Date getTimestamp() {
			return timestamp;
		}

		public String getMessage() {
			return message;
		}

		public String getDetails() {
			return details;
		}

	}

}
