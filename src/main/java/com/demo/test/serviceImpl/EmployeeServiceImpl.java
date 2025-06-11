package com.demo.test.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.test.exception.EmployeeNotFountException;
import com.demo.test.model.Employee;
import com.demo.test.repo.EmployeeRepo;
import com.demo.test.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepo repo;

	@Override
	public Integer addEmployee(Employee employee) {
		
		Integer empId= repo.save(employee).getId();
		
		return empId;
	}

	@Override
	public List<Employee> getEmployee() {
		 
		return repo.findAll();
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		
	  Optional<Employee>e = repo.findById(id);
		Employee emp = e.orElseThrow(()->new EmployeeNotFountException("Employee Not Extst"));
		return emp;
	}
	
	@Override
	public Employee updateEmployee(Employee employee) {
		
		return repo.save(employee);
	}
	
	@Override
	public void deleteEmployee(Integer id) {	
		repo.deleteById(id);
	}

}
