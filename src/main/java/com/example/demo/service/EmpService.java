package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeNotFoundException;

@Service
public class EmpService {
	
	private static List<Employee> emplist = new ArrayList<>();
	
	static {
		emplist.add(new Employee(1L, "hari", "IT"));
	}

	public Employee saveEmployee(Employee employee) {
		emplist.add(employee);
		return employee;
	}

	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return emplist;
	}

	public Employee updateEmployee(Employee employee, long id) throws Exception {
		
		Employee emp = emplist.stream().filter(x-> x.getId()==(id)).findAny().orElseThrow(() -> 
		new EmployeeNotFoundException("emp not found"));
		
		emp.setId(id);
		emp.setName(employee.getName());
		emp.setDeptName(employee.getDeptName());
		
		
		return emp;
	}

}
