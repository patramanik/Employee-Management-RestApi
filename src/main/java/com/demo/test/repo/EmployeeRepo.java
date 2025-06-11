package com.demo.test.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.test.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
