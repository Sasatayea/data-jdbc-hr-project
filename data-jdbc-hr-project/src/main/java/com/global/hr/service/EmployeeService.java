package com.global.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.global.hr.entity.Employee;
import com.global.hr.repository.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	public long count() {
		return employeeRepo.count();
	} 
	
	public Employee findById(Long id) {
		
		return employeeRepo.findById(id).get() ;
	}
	
	public Iterable<Employee> findAll() {
		return employeeRepo.findAll(); 
	}
		
	public Employee insert (Employee emp) {
		return employeeRepo.save(emp);  //null error
	}
	
	public void deleteById (Long id) {
		 employeeRepo.deleteById(id);
	}
	
	public Employee update (Employee emp) {
		return employeeRepo.save(emp);  //null error
	}
	
	
	public  List<Employee> findByName(String name){
		
		return employeeRepo.findByName(name);
	}
	
	public List<Employee> findByNameAndSalary(String name , Double salary){
		
		return employeeRepo.findByNameAndSalary(name, salary);
	}
	
	public List<Employee> findByNameStartingWithAndSalary(String name , Double salary){
		
		return employeeRepo.findByNameStartingWithAndSalary(name, salary);
	}
}
