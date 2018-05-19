package com.practise.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practise.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public List<Employee> getAllEmployee() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Employee");
		List<Employee> employee = query.list();
		return employee;
	}
	
}
