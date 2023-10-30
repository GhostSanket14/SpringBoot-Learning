package com.jbdllecture13firstRestAPI.JBDLrest1.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class employee { // Keep in mind AllArgsConstructor will stop default constructor as we know rule of java.
						// So we have to make it. 
	private int ID;
	private String name;   
	private int age;
	private long createdDate;
	
	private Address address; // These are enums. So only input allowed by enums will be allowed.
	private Department department;
	
//	public employee() {
//		
//	}
	
	// IDK why but toSring is not working with @Getter and @Setter, (Sol- @ToString annotation)
	
}