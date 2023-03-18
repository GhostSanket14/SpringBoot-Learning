package com.persoanlInfoRESTapi.personInfoAPILauncher;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class peopleInfoManager {

	@RequestMapping("/peoples")
	public List<peoples> people(){
		return Arrays.asList( new peoples(21,"Sanket","Kolhapur"), 
				new peoples(22,"Ghost","Heaven"),
				new peoples(24,"Sanket","Pune"));
	}
}