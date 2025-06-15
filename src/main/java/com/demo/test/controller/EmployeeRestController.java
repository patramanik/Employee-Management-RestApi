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

import com.demo.test.dto.ApiResponse;
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
    public ResponseEntity<ApiResponse<List<Employee>>> getEmployee() {

        List<Employee> list = servis.getEmployee();

        boolean isEmpty = list.isEmpty();
        String message = isEmpty ? "Data not present" : "Data fetched successfully";

        ApiResponse<List<Employee>> response = new ApiResponse<>(!isEmpty, message, list);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<Employee>> getEmployeeById(@PathVariable("id") Integer id){
		
		 Employee Emp= servis.getEmployeeById(id);
		
		 ApiResponse<Employee> response = new ApiResponse<Employee>(true, "Data fetched successfully", Emp);
		 
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<ApiResponse<Integer>> addEmployee(@RequestBody Employee emp) {
		
		  Integer id= servis.addEmployee(emp);
		
		ApiResponse<Integer> response = new ApiResponse<>(true, "Employee added  Successfully", id);
		return new ResponseEntity<>(response,HttpStatus.OK);	
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee emp) {
		servis.updateEmployee(emp);
		return new ResponseEntity<String>("Employee Updated  Successfully", HttpStatus.OK);		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse<String>> deleteEmployee(@PathVariable("id") Integer id){
		
		servis.getEmployeeById(id);
		
		servis.deleteEmployee(id);
		
		ApiResponse<String> response = new ApiResponse<>(true, "Employee Deleted Successfully");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	

}
