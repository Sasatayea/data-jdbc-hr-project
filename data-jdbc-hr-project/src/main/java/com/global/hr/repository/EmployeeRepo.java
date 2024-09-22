package com.global.hr.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.global.hr.entity.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Long>{

	List<Employee> findByName(String name);
	
	List<Employee> findByNameAndSalary(String name , Double salary);
	
	List<Employee> findByNameStartingWithAndSalary(String name , Double salary);


}
