package com.mungare.springbootbackend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mungare.springbootbackend.model.Employee;
import com.mungare.springbootbackend.repository.EmployeeRepo;
import com.mungare.springbootbackend.service.EmployeeService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
	
	@Autowired
	public EmployeeService empservice;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		List<Employee>list=empservice.getAllEmployees();
		return list;
	}
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
	Employee  newEmployee=  this.empservice.createEmployee(employee);
	return  newEmployee;
}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee=empservice.getEmployeeById(id);
		return ResponseEntity.ok(employee);
		
	}
	@PutMapping("/employees/{Id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long Id, @RequestBody Employee employeeDetails) {
		Employee newemployee = empservice.updateEmployee(Id ,employeeDetails);
		return ResponseEntity.ok(newemployee);

	}
	@DeleteMapping("employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
		empservice.deleteEmployee(id);
		Map<String, Boolean> response=new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}