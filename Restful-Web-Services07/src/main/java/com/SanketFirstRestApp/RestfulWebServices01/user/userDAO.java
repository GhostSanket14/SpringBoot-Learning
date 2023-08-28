package com.SanketFirstRestApp.RestfulWebServices01.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class userDAO { // This is where actions related to user data/database will happen. In methods.
	
	private static List<user> users=new ArrayList<>();
	static int countId=0; // I have to do this beacuse id coundn't use int with equals() in functional programming.
	static { // We use this static block to create users, for now.
		users.add(new user(++countId,"ASanket",LocalDate.now().plusYears(10)));
		users.add(new user(++countId,"BSanket",LocalDate.now().plusYears(11)));
		users.add(new user(++countId,"CSanket",LocalDate.now().plusYears(13)));
		users.add(new user(++countId,"DSanket",LocalDate.now().plusYears(14)));
		users.add(new user(++countId,"ESanket",LocalDate.now().plusYears(14)));
	}
	
	
	// Method to retrive all users.
	public List<user> findAllUsers(){
		return users;
	}	
	
	// Method to retrive sa specific user.
	public user findSpecifcUser(int id){
		Predicate<? super user> predicate= User-> User.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null); // First we made null here. 
																 
	}

	public user saveUser(user userObj) {
		userObj.setId(++countId);
		users.add(userObj);
		return userObj;
	}	
	public void deleteSpecifcUser(int id){
		Predicate<? super user> predicate= User-> User.getId().equals(id);
		users.removeIf(predicate); // removeIf(); function will remove the user if above predicate get the id and match it with passed parameter(id).																 
	}

}