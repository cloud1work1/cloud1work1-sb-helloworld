package com.sb.cloud1work1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sb.cloud1work1.model.Employee;

@Service
public class EmployeeService {

	private static List<Employee> employeeList = new ArrayList();
	
	static {
		employeeList.add(new Employee(1, "Yudhister Pandav", "yu.pa@mb.com"));
		employeeList.add(new Employee(2, "Bheem Pandav", "bh.pa@mb.com"));
		employeeList.add(new Employee(3, "Arjun Pandav", "ar.pa@mb.com"));
		employeeList.add(new Employee(4, "Nakul Pandav", "na.pa@mb.com"));
		employeeList.add(new Employee(5, "Sahdev Pandav", "sa.pa@mb.com"));
	}
}
