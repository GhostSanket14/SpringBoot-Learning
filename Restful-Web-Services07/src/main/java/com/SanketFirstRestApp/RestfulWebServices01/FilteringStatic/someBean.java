package com.SanketFirstRestApp.RestfulWebServices01.FilteringStatic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"field1","field3"}) // Do this instead of adding @JsonIgnore to each manually. (if there are too many.) It has drawbacks, check notes.
public class someBean {

	private String field1;
	@JsonIgnore  // Now this will be ignored from JSON. ATERNATE- you can also use @JsonIgnorePropertis() 
	private String field2;
	private String field3;
	public someBean(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}
	public String getField1() {
		return field1;
	}
	public String getField2() {
		return field2;
	}
	public String getField3() {
		return field3;
	}
	@Override
	public String toString() {
		return "someBean [field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + ", getField1()="
				+ getField1() + ", getField2()=" + getField2() + ", getField3()=" + getField3() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}