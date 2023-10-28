package com.jbdllecture13firstRestAPI.JBDLrest1.Model;

public class employee {

	private int ID;
	private String name;   
	private int age;
	private long createdDate;
	
	private Address address; // These are enums. So only input allowed by enums will be allowed.
	private Department department;
	
	// There are the getter and setter.
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
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
	public long getCreatedDate() { // we will calculate this and not let user know its existence.
		return createdDate;
	}
	public void setCreatedDate(long createdDate) {
		this.createdDate = createdDate;
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

	
	
	// These are toString and constructors.
//	public employee(int iD, String name, int age, Address address, Department department) {
//		super();
//		ID = iD;
//		this.name = name;
//		this.age = age;
//		this.address = address;
//		this.department = department;
//	}
	@Override
	public String toString() {
		return "employee [ID=" + ID + ", name=" + name + ", age=" + age + ", address=" + address + ", department="
				+ department + ", getID()=" + getID() + ", getName()=" + getName() + ", getAge()=" + getAge()
				+ ", getAddress()=" + getAddress() + ", getDepartment()=" + getDepartment() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}