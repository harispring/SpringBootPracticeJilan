package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmpService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmpService empservice;
	
	@GetMapping("/message")
	public String getMessgae() {
		return "welcome to spring";
	}
	
	@PostMapping("/saveEmployee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(empservice.saveEmployee(employee), HttpStatus.CREATED);
	}
	
	@GetMapping("/getEmplist")
	public List<Employee> getAllEmployees(){
		return empservice.getAllEmployees();
	}
	
	@PutMapping("/updateEmp/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id
												  ,@RequestBody Employee employee) throws Exception{
		return new ResponseEntity<Employee>(empservice.updateEmployee(employee, id), HttpStatus.OK);
	}

}
