package net.guides.springboot2.crud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.crud.exception.ResourceNotFoundException;
import net.guides.springboot2.crud.model.Employee;
import net.guides.springboot2.crud.repository.EmployeeRepository;
import net.guides.springboot2.crud.service.Service;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	private Service service;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return service.getAllEmployees();
	}

	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable(value = "id") Long employeeId){
		return service.getEmployeeById(employeeId);
	}

	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		return service.createEmployee(employee);
	}

	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody Employee employeeDetails){
				return service.updateEmployee(employeeId, employeeDetails);
	}

	@DeleteMapping("/employees/{id}")
	public Employee deleteEmployee(@PathVariable(value = "id") Long employeeId){
		return service.deleteEmployee(employeeId);
	}
}
