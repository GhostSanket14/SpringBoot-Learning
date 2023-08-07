package com.SanketFirstRestApp.RestfulWebServices01.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND) // This will return back not found response status.
public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(String msg) {
		super(msg); // we pass the exception to super exception class.w Where it will be printed.
	}
}