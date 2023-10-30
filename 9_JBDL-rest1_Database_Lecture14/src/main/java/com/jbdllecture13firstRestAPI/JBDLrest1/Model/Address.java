package com.jbdllecture13firstRestAPI.JBDLrest1.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Address {

	private int pinCode;
	private String city;
	
}