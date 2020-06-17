package com.sb.cloud1work1.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sb.cloud1work1.model.Employee;
import com.sb.cloud1work1.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;

	@GetMapping("/")
	public ResponseEntity<List<Employee>> findAll() {
		List<Employee> employeeList = empService.findAll();
		return new ResponseEntity<List<Employee>>(employeeList,HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<Object> save(@RequestBody Employee employee){
		if(employee.getId()==0) {
			List<Employee> employeeList = empService.findAll();
			employee.setId(employeeList.size()+1);
		}
		empService.save(employee);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/emp/{id}")
	public ResponseEntity<Optional<Employee>> findById(@PathVariable("id") int id){
		return new ResponseEntity<Optional<Employee>>(empService.findById(id), HttpStatus.OK);
	}
}
