package com.jbdllecture13firstRestAPI.JBDLrest1.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbdllecture13firstRestAPI.JBDLrest1.DTO.creatEmployeeRequest;
import com.jbdllecture13firstRestAPI.JBDLrest1.DTO.updateEmployeeRequest;
import com.jbdllecture13firstRestAPI.JBDLrest1.Model.employee;
import com.jbdllecture13firstRestAPI.JBDLrest1.Repository.employeeRepository;


@Service
public class EmployeeService {
 
	@Autowired
	employeeRepository empRepo;
	
	public employee createEmp(creatEmployeeRequest createEmpRequest) {
		employee Employee=createEmpRequest.to(); // we saturate Model/DTO using JSON.
		return empRepo.createEmployeeIntoDatabase(Employee);
	}
	public employee getEmployee(int iD) {
		return empRepo.getCreatedEmployeeFromDatabase(iD);
	}
	// Here we can see overloading.
	public List<employee> getEmployee() {
		return empRepo.getCreatedEmployeeFromDatabase();
	}
	

	// Update- PUT
	public employee putIntoEmployee(int ID, updateEmployeeRequest updateEmpRequest) {
		employee Employee=updateEmpRequest.to();
		return empRepo.updateEmployeeIntoDatabase(ID, Employee);
		
	}
	
	// Delete
	public boolean deleteEmp(int ID) {
		boolean statusOfDelete=empRepo.deleteEmployee(ID);
		if(statusOfDelete==true) {
			return true;
		}
		return false;
	}
	
	// In future this function will fetch and get ID from database;
	public static int createID() {
        // Generate a random integer between the specified range (inclusive)
        int min = 1;
        int max = 100;
        int randomInt = ThreadLocalRandom.current().nextInt(min, max + 1); // For now this values will be hard coded.
		return randomInt;
	}

}