package com.global.hr.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("employee")
public class Employee {
	
	@Id
	@Column("id")
	private Long employeeId ;
	private String name ;
	private double salary ;
	
	@Transient
	private Boolean isCreate ; 
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(Object op , String name, double salary) {
		super();
		this.employeeId = (Long) op;
		this.name = name;
		this.salary = salary;
	}
	
	public Employee(long id, String name, double salary) {
		super();
		this.employeeId = id;
		this.name = name;
		this.salary = salary;
	}


	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public Boolean getIsCreate() {
		return isCreate;
	}
	public void setIsCreate(Boolean isCreate) {
		this.isCreate = isCreate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
