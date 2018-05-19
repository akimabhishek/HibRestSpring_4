package com.practise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.practise.entity.Employee;
import com.practise.service.EmployeeService;

@Controller
public class MainController {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	public ModelAndView welcomepage() {
		ModelAndView model = new ModelAndView("success");
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public List<Employee> listofEmployee() {
		List<Employee> employee = employeeService.getAllEmployee();
		for(Employee e : employee) {
			System.out.println(e.getID()+" "+e.getNAME()+" "+e.getDEPT());
			System.out.println();
		}
		return employee;
	}
	
	@ResponseBody 
	@RequestMapping(value="list/{id}", method=RequestMethod.GET)
	public Employee getEmployeebyID(@PathVariable ("id") int id) {
			Employee employee = employeeService.getEmployee(id);
			return employee;	
	}
	
	@RequestMapping(value="/list/{id}",method=RequestMethod.PUT)
	public void updateRecord(@PathVariable("id") int id, @RequestBody Employee employee) {
		 employeeService.update(employee);		
	}
	
	@RequestMapping(value="/list/{id}",method=RequestMethod.DELETE) 
	public void deleteRecord(@PathVariable("id") int id) {
		 employeeService.delete(id);
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST) 
	public void saveEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
	}
	
}
