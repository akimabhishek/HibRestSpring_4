package com.practise.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
		session.close();
		return employee;
	}
	
	public Employee getEmployee(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		Employee employee = new Employee();
		try {
		transaction = session.beginTransaction();	
		Query query = session.createQuery("from Employee where id="+id);
		employee = (Employee)query.uniqueResult();
		transaction.commit();
		
		}
		catch(HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return employee;
	}
	
	public void update(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
		transaction = session.beginTransaction();
		String hql = "update Employee set NAME = :NAME, DEPT = :DEPT where ID = :ID";
		Query query = session.createQuery(hql);
		query.setInteger("ID", employee.getID());
		query.setString("NAME", employee.getNAME());
		query.setString("DEPT", employee.getDEPT());
		query.executeUpdate();
		transaction.commit();
		}
		catch(HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}	
	}
	
	public void delete(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
		transaction = session.beginTransaction();
		String hql = "delete from Employee where ID = :ID";
		Query query = session.createQuery(hql);
		query.setInteger("ID",id);
		query.executeUpdate();
		
		//Alternate
		/*String hql = "from Employee where ID = :ID";
		Query query = session.createQuery(hql);
		Employee employee = (Employee)query.uniqueResult();
		session.delete(employee);*/
		
		transaction.commit();
		}
		catch(HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
	
	public void saveEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(employee);
			transaction.commit();
		}
		catch(HibernateException e)
		{
			transaction.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}	
}
