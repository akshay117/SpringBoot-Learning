package com.demo.EmployeeConsumer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.EmployeeConsumer.Model.Employee;
import com.demo.EmployeeConsumer.Service.EmployeeService;

@RestController
@RequestMapping("/employee-consumer")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public String saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmp(employee);
		
	}
	
	@GetMapping
	public List<Employee> getAll(){
		return employeeService.getEmp();
	}

}
