package com.gl.employeeManagementSystem.service;

import java.util.List;
import java.util.Optional;

import com.gl.employeeManagementSystem.entity.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployee();
	
	Employee getEmployeeById(Long Id);
	
	Employee saveEmployee(Employee employee);
	
	Employee updateEmployee(Employee employee);
	
	void deleteEmployeeById(Long Id);
	

}
