package com.jbdllecture13firstRestAPI.JBDLrest1.DTO;

import com.jbdllecture13firstRestAPI.JBDLrest1.Model.Address;
import com.jbdllecture13firstRestAPI.JBDLrest1.Model.Department;
import com.jbdllecture13firstRestAPI.JBDLrest1.Model.employee;
import com.jbdllecture13firstRestAPI.JBDLrest1.Service.EmployeeService;

public class creatEmployeeRequest {
	// we will take only these as inputs and rest will be calculated and filled by us into the model, 'employee'
	// This 
	
	private String name;   
	private int age;
	private Address address;
	private Department department;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	// This is DTO to data model.
	public employee to() {
		employee newEmp=new employee();
		
		newEmp.setName(this.name);
		newEmp.setAge(this.age);
		newEmp.setID(EmployeeService.createID());
		newEmp.setAddress(this.address);
		newEmp.setDepartment(this.department);
		newEmp.setCreatedDate(System.currentTimeMillis());
		
		return newEmp;
	}
}

// This is the JASON format i passed.

//{
//"name":"sanket",
//"age":"23",
//"department" : "HR",
//"address":{
//	"pinCode":"416502",
//    "city":"Kolhapur"
//}
//}