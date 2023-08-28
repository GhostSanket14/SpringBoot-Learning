package com.SanketFirstRestApp.RestfulWebServices01.user;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class user {

	private Integer id; // Made it wrapper for functional programming. same below for constructor and getter.
	
	@Size(min=2, message = "Name should have atleast 2 characters") // Ctrl + click to open @Size and know what else it can offer. 
	@JsonProperty("User_name") // previously 'name' below was also 'name' in json. But now in json it will be 'User_name'
	private String name;
	
	@Past(message = "Date sould be in Past") // These errors will be caught by @Vaild and handled by our custom method in Exception package
	private LocalDate birthdate;
	public user(Integer id, String name, LocalDate birthdate) {
		super();
		
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	@Override
	public String toString() {
		return "user [id=" + id + ", name=" + name + ", birthdate=" + birthdate + "]";
	}	
}