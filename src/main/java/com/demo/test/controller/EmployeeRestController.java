package com.demo.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.test.model.Employee;
import com.demo.test.repo.EmployeeRepo;
import com.demo.test.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

    private final EmployeeRepo employeeRepo;
	
	@Autowired
	private EmployeeService servis;

    EmployeeRestController(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
	
	@GetMapping("/")
	public ResponseEntity<List<Employee>> getEmployee(){
		
		List<Employee> list =servis.getEmployee();
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id){
		
		 Employee EmpList= servis.getEmployeeById(id);
		 
		return new ResponseEntity<Employee>(EmpList, HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> addEmployee(@RequestBody Employee emp) {
		
		servis.addEmployee(emp);
		
		return new ResponseEntity<String>("Employee added  Successfully",HttpStatus.OK);	
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee emp) {
		servis.updateEmployee(emp);
		return new ResponseEntity<String>("Employee Updated  Successfully", HttpStatus.OK);		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Integer id){
		
		servis.getEmployeeById(id);
		
		servis.deleteEmployee(id);
		return new ResponseEntity<String>("Employee Deleted Successfully", HttpStatus.OK);
	}
	
	

}
