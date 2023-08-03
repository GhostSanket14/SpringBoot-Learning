package com.SanketFirstRestApp.RestfulWebServices01.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userResources {
	// Basically we keep RestController clean. By having all business logic in DAO.	
	
	private userDAO userDaoObj;

	public userResources(userDAO userDaoObj) {
		super();
		this.userDaoObj = userDaoObj;
	}

	@GetMapping("/users")
	public List<user> findAllUsers(){ 
		return userDaoObj.findAllUsers();
	}
	@GetMapping("/users/{name}")
	public user findAllUsers(@PathVariable String name){ 
		return userDaoObj.findSpecifcUser(name);
	}
	
	@PostMapping("/users")
	public void CreateUser(@RequestBody user userObj){ 
		userDaoObj.saveUser(userObj);
	}
}