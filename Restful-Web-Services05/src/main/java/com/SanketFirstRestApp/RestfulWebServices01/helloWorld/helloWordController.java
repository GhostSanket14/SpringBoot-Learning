package com.SanketFirstRestApp.RestfulWebServices01.helloWorld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWordController {
	
	
	private MessageSource msgSrcObj; // Lec 150. Using it to get msg from meaasge.properties
	public helloWordController(MessageSource msgSrcObj) {
		this.msgSrcObj=msgSrcObj;
	}
	
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
	
	@GetMapping(path="/hello-world-international")  
	public String helloWorldInternationalize() {
		Locale localObj=LocaleContextHolder.getLocale(); // It will give us local given with current header. 
						// eg. if user send accept header (nl) locale will catch and return it which we will use in getMessage() below to access appropriate message_.properties.
		return msgSrcObj.getMessage("good.morning.message", null, "Ithe default msg ahe ", localObj); // If nothing then locale return default locale 
	}
	
}