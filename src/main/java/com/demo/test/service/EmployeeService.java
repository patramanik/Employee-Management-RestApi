package com.demo.test.service;

import java.util.List;
import java.util.Optional;

import com.demo.test.model.Employee;

public interface EmployeeService {

	public Integer addEmployee(Employee employee);
	
	public List<Employee> getEmployee();
	
	public Employee getEmployeeById(Integer id);
	
	public Employee updateEmployee(Employee employee);
	
	public void deleteEmployee(Integer id);
	
}
