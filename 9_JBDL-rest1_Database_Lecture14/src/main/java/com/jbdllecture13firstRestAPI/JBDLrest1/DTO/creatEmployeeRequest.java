package com.jbdllecture13firstRestAPI.JBDLrest1.DTO;

import com.jbdllecture13firstRestAPI.JBDLrest1.Model.Address;
import com.jbdllecture13firstRestAPI.JBDLrest1.Model.Department;
import com.jbdllecture13firstRestAPI.JBDLrest1.Model.employee;
import com.jbdllecture13firstRestAPI.JBDLrest1.Service.EmployeeService;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class creatEmployeeRequest {
	// we will take only these as inputs and rest will be calculated and filled by us into the model, 'employee'
	// This 
	
	@NotBlank
	private String name;
	@Min(18)
	@Max(50)
	private int age;
	private Address address;
	@NotNull 
	private Department department; // As department is enum, we cant make it null (even with default). So here @NotNull makes sence.
	
	// This is DTO to data model.
	public employee to() {
		employee newEmp=employee.builder() // This way we can use builder to make object.		
		
		.name(this.name)   // Nothing difficult we just assigned values to variables like this.
		.age(this.age)
		.ID(EmployeeService.createID())
		.address(this.address)
		.department(this.department)
		.createdDate(System.currentTimeMillis())
		
		.build(); // This function is also present in inner static class made by Builder.
		
		return newEmp;
	}
	
	
	
}