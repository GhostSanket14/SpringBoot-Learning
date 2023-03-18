package com.persoanlInfoRESTapi.personInfoAPILauncher;

import org.springframework.stereotype.Component;

public class peoples {

	private int age;
	private String name;
	private String city;
	
	public peoples(int age, String name, String city) {
		super();
		this.age = age;
		this.name = name;
		this.city = city;
	}
	
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public String getCity() {
		return city;
	}

	public String toString() {
		return "peoples [Age=" + age + ", name=" + name + ", city=" + city + "]";
	}	
}