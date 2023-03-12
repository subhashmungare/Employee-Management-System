package com.mungare.springbootbackend.service;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mungare.springbootbackend.exception.ResourceNotFoundException;
import com.mungare.springbootbackend.model.Employee;
import com.mungare.springbootbackend.repository.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepo empRepo;
	
	public List<Employee> getAllEmployees() {
		  return empRepo.findAll();
		
		
	}

	public Employee createEmployee(Employee employee) {
		Employee newEmployee=this.empRepo.save(employee);
		return newEmployee;
	}

	

	public Employee getEmployeeById(Long id) {
		Employee employee=empRepo.findById(id)
				.orElseThrow(() ->new ResourceNotFoundException("Employee not exit with id: "+  id));
		return employee;
	}
	
	




	public Employee updateEmployee(Long id, Employee employeeDetails) {
		
		Employee employee=empRepo.findById(id)
				.orElseThrow(() ->new ResourceNotFoundException("Employee not exit with id: "+  id));
		
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());
		Employee updatedemployee=empRepo.save(employee);
		
		return updatedemployee;

		
	}

	public void deleteEmployee(Long id) {
		Employee employee=empRepo.findById(id)
				.orElseThrow(() ->new ResourceNotFoundException("Employee not exit with id: "+  id));
		
		empRepo.delete(employee);
	}}
