package com.jbdllecture13firstRestAPI.JBDLrest1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jbdllecture13firstRestAPI.JBDLrest1.DTO.creatEmployeeRequest;
import com.jbdllecture13firstRestAPI.JBDLrest1.DTO.updateEmployeeRequest;
import com.jbdllecture13firstRestAPI.JBDLrest1.Model.employee;
import com.jbdllecture13firstRestAPI.JBDLrest1.Service.EmployeeService;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;

@RestController
public class employeeController {
		
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/employeeCreate") // json received from POST in saved into 'createEmpResuest' 
	public employee createEmployee(@RequestBody @Valid creatEmployeeRequest createEmpResuest){
		return employeeService.createEmp(createEmpResuest);
	}
	
	@GetMapping("/seeCreatedEmployee/{empPathVariable}")
	public employee seeEmployee(@PathVariable("empPathVariable") int ID){
		return employeeService.getEmployee(ID);
	}
	
	@GetMapping("/seeAllEmployees/all")
	public List<employee> getAllEmployee(){
		return employeeService.getEmployee();
	}
	
	@PutMapping("/updateEmployees/{IdToUpdate}")
	public employee updateTheEmployee(@PathVariable("IdToUpdate") int ID, @RequestBody updateEmployeeRequest updateEmpResuest){ 
		return employeeService.putIntoEmployee(ID, updateEmpResuest);
	}

	@DeleteMapping("/deleteEmployee/{iDToDelete}")
	public String deleteTheEmployee(@PathVariable("iDToDelete") int ID) {
		boolean status=employeeService.deleteEmp(ID);
		if(status==true) {
			return "Employee Data Daleted";
		}else {
			return "Employee dataNot deleted or Employee Dont exist";
		}
	}

}