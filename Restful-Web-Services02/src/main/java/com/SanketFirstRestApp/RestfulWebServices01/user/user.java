package com.SanketFirstRestApp.RestfulWebServices01.user;

import java.time.LocalDate;

public class user {

	private Integer id; // Made it wrapper for functional programming. same below for constructor.
	private String name;
	private LocalDate birthdate;
	public user(Integer id, String name, LocalDate birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
	}
	public int getId() {
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