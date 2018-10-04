package br.com.ricardoludwig.customer.rest;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.ricardoludwig.customer.model.exception.InvalidCustomerException;
import br.com.ricardoludwig.customer.model.exception.InvalidEmailException;
import br.com.ricardoludwig.customer.model.exception.InvalidLoginException;
import br.com.ricardoludwig.customer.model.exception.InvalidNameException;
import br.com.ricardoludwig.customer.repository.exception.CustomerAlreadyExistException;
import br.com.ricardoludwig.customer.repository.exception.CustomerNotFoundException;

@ControllerAdvice(basePackageClasses = Controller.class)
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

	@ResponseBody
	@ExceptionHandler(InvalidNameException.class)
	ResponseEntity<?> handleInvalidNameException(WebRequest request, InvalidNameException ex) {
		ResponseHandler respEx = new ResponseHandler(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(respEx, HttpStatus.BAD_REQUEST);
	}
	
	@ResponseBody
	@ExceptionHandler(InvalidEmailException.class)
	ResponseEntity<?> handleInvalidEmailException(WebRequest request, InvalidEmailException ex) {
		ResponseHandler respEx = new ResponseHandler(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(respEx, HttpStatus.BAD_REQUEST);
	}
	
	@ResponseBody
	@ExceptionHandler(InvalidLoginException.class)
	ResponseEntity<?> handleInvalidLoginException(WebRequest request, InvalidLoginException ex) {
		ResponseHandler respEx = new ResponseHandler(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(respEx, HttpStatus.BAD_REQUEST);
	}
	
	@ResponseBody
	@ExceptionHandler(CustomerNotFoundException.class)
	ResponseEntity<?> handleCustomerNotFoundException(WebRequest request, CustomerNotFoundException ex) {
		ResponseHandler respEx = new ResponseHandler(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(respEx, HttpStatus.NOT_FOUND);
	}
	
	@ResponseBody
	@ExceptionHandler(CustomerAlreadyExistException.class)
	ResponseEntity<?> handleCustomerAlreadyExistFoundException(WebRequest request, CustomerAlreadyExistException ex) {
		ResponseHandler respEx = new ResponseHandler(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(respEx, HttpStatus.CONFLICT);
	}
	
	@ResponseBody
	@ExceptionHandler(InvalidCustomerException.class)
	ResponseEntity<?> handleInvalidCustomerException(WebRequest request, InvalidCustomerException ex) {
		ResponseHandler respEx = new ResponseHandler(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(respEx, HttpStatus.BAD_REQUEST);
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
