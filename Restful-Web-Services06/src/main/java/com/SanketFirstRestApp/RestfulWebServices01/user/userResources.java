package com.SanketFirstRestApp.RestfulWebServices01.user;

import java.net.URI;
import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

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
	public EntityModel<user> findOneUsers(@PathVariable int id){ 
		user oneUser= userDaoObj.findSpecifcUser(id);
	
		if(oneUser==null) {
			throw new UserNotFoundException("The user with id:"+id+" dont exist "); // This msg will be given to exception class
		}
		EntityModel<user> emO=EntityModel.of(oneUser); // We created entity model for the class.
		
		WebMvcLinkBuilder link=linkTo(methodOn(this.getClass()).findAllUsers()); // This way we get links.
		emO.add(link.withRel("All-users")); // Here we add link to the EnityModel. ( 'All users' is basically title of links in JSON). Lec 154 SS4
		
		return emO;
	}
	
	@PostMapping("/users")
	public ResponseEntity<user> CreateUser(@Valid @RequestBody user userObj){  
		user userForRequest=userDaoObj.saveUser(userObj);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userForRequest.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}") // Lets try to send delete request from web now.
	public void DeleteOneUsers(@PathVariable int id){ 
	userDaoObj.deleteSpecifcUser(id);
	}
	
}