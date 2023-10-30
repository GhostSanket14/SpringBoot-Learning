package com.jbdllecture13firstRestAPI.JBDLrest1.DTO;

import com.jbdllecture13firstRestAPI.JBDLrest1.Model.Address;
import com.jbdllecture13firstRestAPI.JBDLrest1.Model.Department;
import com.jbdllecture13firstRestAPI.JBDLrest1.Model.employee;
import com.jbdllecture13firstRestAPI.JBDLrest1.Service.EmployeeService;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class updateEmployeeRequest {
	// What's different here is that it has to respect the rules of PUT. So there no need to change ID as rest can change but ID cant.

	private String name;   
	private int age;
	private Address address;
	private Department department;
	
	// This is called builder pattern.  
	public employee to() {  // Here id we dont assign value to a attribute, it will get default value.
		employee newEmp=employee.builder()
				.name(this.name)
				.age(this.age)
				.address(this.address)
				.department(this.department)
				.build();
		
//		employee.builder().build(); <-- This will internally create a static inner class, which will be used to make object.
		
		return newEmp;
	}
}
//
//// This is internal working of Builder
//Person person = Person.builder()
//.firstName("John")
//.age(30)
//.build();   Tell me internal functioning of this
//ChatGPT
//The internal functioning of the code you provided using Lombok's @Builder annotation involves the generation of a builder class and the creation of a Person object with the specified field values. Here's a step-by-step explanation of what happens internally:
//
//Builder Class Generation: When you compile your code, Lombok generates a builder class within the Person class. This builder class is typically named PersonBuilder by default.
//
//Method Chaining: When you call Person.builder(), you're actually creating an instance of the generated builder class (PersonBuilder). The builder class has methods corresponding to the fields of the Person class. In your case, it has methods like firstName(String firstName) and age(int age).
//
//Setting Field Values: With the method chaining, you set the field values by invoking the builder methods. For example:
//
//java
//Copy code
//Person person = Person.builder()
//.firstName("John")
//.age(30)
//Here, you set the firstName to "John" and the age to 30. If you don't explicitly set a field, it will have its default value.
//
//build() Method: After specifying the desired field values, you call the build() method on the builder:
//
//java
//Copy code
//.build();
//The build() method creates an instance of the Person class with the field values you've specified.
//
//Object Creation: The build() method collects the field values that you've set using the builder methods and constructs a Person object. In your example, it will create a Person object with the firstName set to "John," the age set to 30, and the lastName set to its default value (which is null).
//
//So, in summary, Lombok's @Builder annotation automates the process of creating a builder class, setting field values using method chaining, and constructing a Person object with the specified field values when you call the build() method. This approach makes it easy to create instances of your class with only the fields you want to set, and it keeps your code clean and readable.
//
