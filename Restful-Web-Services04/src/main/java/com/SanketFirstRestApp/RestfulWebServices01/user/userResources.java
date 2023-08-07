package com.SanketFirstRestApp.RestfulWebServices01.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	@GetMapping("/users/{id}")
	public user findOneUsers(@PathVariable int id){ 
		user oneUser= userDaoObj.findSpecifcUser(id);
	
		if(oneUser==null) {
			throw new UserNotFoundException("The user with id:"+id+" dont exist "); // This msg will be given to exception class
		}
		
		return oneUser;
	}
	
	@PostMapping("/users")
	public ResponseEntity<user> CreateUser(@RequestBody user userObj){ 
		user userForRequest=userDaoObj.saveUser(userObj);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userForRequest.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}") // Lets try to send delete request from web now.
	public void DeleteOneUsers(@PathVariable int id){ 
	userDaoObj.deleteSpecifcUser(id);
	}
	
}