package com.practise.service;

import java.util.List;

import com.practise.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployee();
	public Employee getEmployee(int id);
	public void update(Employee employee);
	public void delete(int id);
	public void saveEmployee(Employee employee);

}
