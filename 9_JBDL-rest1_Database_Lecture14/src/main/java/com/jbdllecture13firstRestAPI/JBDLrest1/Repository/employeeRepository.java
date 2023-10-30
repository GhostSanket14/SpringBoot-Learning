package com.jbdllecture13firstRestAPI.JBDLrest1.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.jbdllecture13firstRestAPI.JBDLrest1.Model.employee;


@Repository
public class employeeRepository {
	HashMap<Integer, employee> employeeData=new HashMap<>();
	
	public employee createEmployeeIntoDatabase(employee Employee) {
		return null;
	}

	public employee getCreatedEmployeeFromDatabase(int iD) {
		return null;
	}
	
	public List<employee> getCreatedEmployeeFromDatabase() {
		return null;
	}
 
	public employee updateEmployeeIntoDatabase(int ID, employee employee) {
		return null;
	}

	public employee mergeLogic(employee oldObj, employee newObj) {
		return null;
	}

	public boolean deleteEmployee(int ID) {
		return null != null;
	}
	
	
}