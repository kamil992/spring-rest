package springrest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import springrest.entity.PersonErrorResponse;

// handling all exceptions
@ControllerAdvice
public class ExceptionController {
	
	//if bad id
		@ExceptionHandler
		public ResponseEntity<PersonErrorResponse> handleException(PersonNotFoundException exc){
			PersonErrorResponse studentErrorResponse =
					new PersonErrorResponse();
			
			studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
			studentErrorResponse.setMessage(exc.getMessage());
			studentErrorResponse.setTimeStamp(System.currentTimeMillis());
			
			return new ResponseEntity<>(studentErrorResponse, HttpStatus.NOT_FOUND);
		}
		
		//if another bad data like letters or another sighs
		@ExceptionHandler
		public ResponseEntity<PersonErrorResponse> handleException(Exception exc){
			PersonErrorResponse studentErrorResponse =
					new PersonErrorResponse();
			
			studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
			studentErrorResponse.setMessage(exc.getMessage());
			studentErrorResponse.setTimeStamp(System.currentTimeMillis());
			
			return new ResponseEntity<>(studentErrorResponse, HttpStatus.BAD_REQUEST);
		
	}

}
