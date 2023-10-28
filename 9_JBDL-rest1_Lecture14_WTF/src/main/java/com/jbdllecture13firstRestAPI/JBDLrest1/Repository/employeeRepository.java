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
		employeeData.put(Employee.getID(), Employee); 
		// IMP- If there was no previous mapping for the key (i.e., the key is being added for the first time),
		// the method returns null. If there was a previous mapping for the key, the method returns previous value associated with that key.
		return employeeData.get(Employee.getID()); // This way w can immediately check if above our value was added.
	}

	public employee getCreatedEmployeeFromDatabase(int iD) {
		if(employeeData.containsKey(iD)) {
		return employeeData.get(iD);
		}else {
		return null;
		}
	}
	
	public List<employee> getCreatedEmployeeFromDatabase() {
		return employeeData
				.values()
				.stream()
				.collect(Collectors.toList()); // To convert to list in collector.
	}

	// TIP- 001
	// This will work for our code. But it is possible in real life there might be some data that we can't take from user
	// But as PUT require entire data. So we have to merge new values, old existing values (which we have to retrieve)
	// Merge logic of Put is also same for Patch. (In real life, DEVS mostly use the Patch) 
	public employee updateEmployeeIntoDatabase(int ID, employee employee) {
		if(employeeData.containsKey(ID)) {
			employee=mergeLogic(employeeData.get(ID), employee); // First parameter is to get existing data object, second is user updated.
			
			employeeData.put(ID, employee); // This way our put/patch updated DTO will be put. And key will remain the same.
			return employeeData.get(ID);
		}else {
			return null;
		} 
	}
	// In future we will learn to use DI/auto-wiring or other Libraries for merging, this is not a idea way to do it. 
	// as there can be lot of missing fields in case.
	public employee mergeLogic(employee oldObj, employee newObj) {
		newObj.setCreatedDate(oldObj.getCreatedDate());
		return newObj;
	}

	public boolean deleteEmployee(int ID) {
		if(employeeData.containsKey(ID)) {
			employeeData.remove(ID);
			return true;
		}
		return false;
	}
	
	
}