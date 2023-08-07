package com.SanketFirstRestApp.RestfulWebServices01.helloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWordController {
	
	@GetMapping(path="/hello-world-bean")  
	public helloWorldBean helloWorldBean() {
		return new helloWorldBean("Hello my BOI");
	}
	
	@GetMapping(path="/hello-world/path-variable/{name}") // This is how we make path variable. Ie, {}
	public helloWorldBean helloWorldPathVariable(@PathVariable String name) { // here the @pathVaribale object name must match with 
		return new helloWorldBean(									// variable in the URL above.
				String.format("Hello my BOI %s ",name) // We will use string format to direct put value. (Node- use 'comma'  '+' dont work)
				);														 		
	}
}