package com.SanketFirstRestApp.RestfulWebServices01.FilteringDynamic;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("SomeBeanFilter") // This is the we made earlier.
public class someBeanDyna {

	private String field1;
	private String field2;
	private String field3;
	public someBeanDyna(String field1, String field2, String field3) {
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