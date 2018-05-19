package com.practise.dao;

import java.util.List;

import com.practise.entity.Employee;

public interface EmployeeDao {
	
	public List<Employee> getAllEmployee() ;
	public Employee getEmployee(int id);
	public void update(Employee employee);
	public void delete(int id);
	public void saveEmployee(Employee employee);
}
