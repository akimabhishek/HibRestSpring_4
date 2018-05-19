package com.practise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practise.dao.EmployeeDao;
import com.practise.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao;
	
	public List<Employee> getAllEmployee() {
		return employeeDao.getAllEmployee();
	}
	public Employee getEmployee(int id) {
		return employeeDao.getEmployee(id);
	}
	public void update(Employee employee) {
		 employeeDao.update(employee);
	}
	
	public void delete(int id) {
		 employeeDao.delete(id);
	}
	
	public void saveEmployee(Employee employee) {
		employeeDao.saveEmployee(employee);
	}
	
}
