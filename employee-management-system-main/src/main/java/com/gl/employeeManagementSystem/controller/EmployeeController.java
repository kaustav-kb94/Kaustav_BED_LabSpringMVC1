package com.gl.employeeManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gl.employeeManagementSystem.entity.Employee;
import com.gl.employeeManagementSystem.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	
	@GetMapping("/employees")
	public String getEmployees(Model model) {
		List<Employee> employees = employeeService.getAllEmployee();
		model.addAttribute("employees", employees);
		return "employees";	
	}
	
	@GetMapping("/employees/new")
	 public String createEmployeeForm(Model model) {
	  Employee employee = new Employee();
	  model.addAttribute("employee",employee);
	  return "create_employee";
	 }
	
	@PostMapping("/employees")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		Employee savedEmployee = employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}
	
	@GetMapping("/employees/edit/{id}")
	public String editEmployeeForm(@PathVariable Long id, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "edit_employee";
		
	}
	
	@PostMapping("/employees/{id}")
	public String updateEmployee(@PathVariable Long id, @ModelAttribute("employee") Employee employee) {
		Employee fetchEmpById = employeeService.getEmployeeById(id);
		fetchEmpById.setFirstName(employee.getFirstName());
		fetchEmpById.setLastName(employee.getLastName());
		fetchEmpById.setEmail(employee.getEmail());
		Employee updateEmployee = employeeService.saveEmployee(fetchEmpById);
		return "redirect:/employees";
	}
	
	@GetMapping("/employees/{id}")
	public String updateEmployee(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/employees";
	}

}
