package com.bex.spring.MVC.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bex.spring.MVC.domain.Employee;

@RestController
@Transactional(transactionManager="transactionManager")
public class MainController {

	@PersistenceContext
	private EntityManager em;

	@RequestMapping(value = "/home/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Employee getEmployeeInJSON(@PathVariable String name, @RequestHeader(value="User-Agent") String browser) {
		Employee employee = new Employee();
		//Employee emp1 = em.find(Employee.class, Integer.valueOf(name));
		employee.setName(name);
		employee.setEmail(name+"@gmail.com");
		em.persist(employee);
		return employee;
	}

	@RequestMapping(value = "/home/{name}.xml", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody Employee getEmployeeInXML(@PathVariable String name) {
		Employee employee = new Employee();
		employee.setName(name);
		employee.setEmail("employee1@genuitec.com");

		return employee;

	}
}
