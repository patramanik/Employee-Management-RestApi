package com.demo.test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class Employee {
	
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private Double empSalary;
	private String empDept;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(Integer id, String name, Double empSalary, String empDept) {
		super();
		this.id = id;
		this.name = name;
		this.empSalary = empSalary;
		this.empDept = empDept;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(Double empSalary) {
		this.empSalary = empSalary;
	}
	public String getEmpDept() {
		return empDept;
	}
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", empSalary=" + empSalary + ", empDept=" + empDept + "]";
	}
	
	

}
