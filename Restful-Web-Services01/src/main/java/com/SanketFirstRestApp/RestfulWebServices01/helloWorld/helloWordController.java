package com.SanketFirstRestApp.RestfulWebServices01.helloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWordController {

	@RequestMapping(method=RequestMethod.GET, path="/hello-world") // We used 'path' instead of 'value'
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path="/hello-world-new") // We can use @GetMapping for get requests. 
	public String helloWorldNew() {	 // This also means we dont have to write ' method=RequestMethod.GET '
		return "Hello NEW World";
	}

	@GetMapping(path="/hello-world-bean") // Returning a bean 
	public helloWorldBean helloWorldBean() {	 // we used a class to be a bean, which will be used to store and return data.
		return new helloWorldBean("Hello my BOI"); // We are basically returning instance of a class.
	}
	
}