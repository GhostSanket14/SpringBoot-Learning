package com.SanketFirstRestApp.RestfulWebServices01.Exception;

import java.security.Signature;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.SanketFirstRestApp.RestfulWebServices01.user.UserNotFoundException;


@ControllerAdvice // This means this class defines the Exception handlers.
public class customizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{ // as we have overriden this now SB will use our custom error and not inbuilt errors.
	
	// BASICALLY here we are making methods to handle all exceptions. But custom.
	
	@ExceptionHandler(Exception.class) // This means we cant to handle all exceptions.
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		
		ErrorDetails errorDetailObj=new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity(errorDetailObj, HttpStatus.INTERNAL_SERVER_ERROR);
	}


	// I made this for User not found exception.
	// Below is UserNotFoundException used which i made. Basically now what happens is This custom method will run for my exception class. Thus giving me freedom to show data and code i want.
	@ExceptionHandler(UserNotFoundException.class) // This way we can made more exceptions class, make different exceptionHandler to make different type of custom response.
	public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		
		ErrorDetails errorDetailObj=new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity(errorDetailObj, HttpStatus.NOT_FOUND); // NOT_FOUND because i want to give 404 for page not found.
	}
	
	// We basically made this method to handle @Valid
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

			ErrorDetails errorDetails= new ErrorDetails(LocalDateTime.now(), "Total Errors:" + ex.getErrorCount() + " First Error:" + ex.getFieldError().getDefaultMessage(), request.getDescription(false));
		
			return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
	}

}