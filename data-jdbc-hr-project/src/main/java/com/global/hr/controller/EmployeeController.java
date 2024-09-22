package com.global.hr.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.global.hr.entity.Employee;
import com.global.hr.repository.EmployeeRepo;
import com.global.hr.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employee")
//////////// servise layer
public class EmployeeController {

	Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	
//	@GetMapping("/count")
	@RequestMapping(method = RequestMethod.GET , path = "/count")
	public long countEmp() {
		return employeeService.count();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		return  ResponseEntity.ok(employeeService.findById(id))  ; 
	}
	
	@GetMapping("")
	public Iterable<Employee> findAll() {
		return employeeService.findAll(); 
	}
	

	@PostMapping("")
	public Employee addEmp (@RequestBody Employee emp) {
		return employeeService.insert(emp);  //null error
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmp (@PathVariable Long id) {
		employeeService.deleteById(id);
	}
	
	@PutMapping("")
	public Employee updateEmp (@RequestBody Employee emp) {
		return employeeService.update(emp);  //null error
	}
	
	@GetMapping("/filter/{name}")
	public List <Employee> filter (@PathVariable String name) {
		return employeeService.findByName(name) ;
	}
	
	@GetMapping("/filter")
	public List <Employee> findByNameAndSalary (@RequestParam String name , @RequestParam Double salary) {
		return employeeService.findByNameAndSalary(name, salary) ;
	}
	
	@GetMapping("/filterr/{name}/{salary}")
	public List <Employee> FindByNameStartingWithAndSalary (@PathVariable String name , @PathVariable Double salary) {
		return employeeService.findByNameStartingWithAndSalary(name, salary) ;
	}
}
