package com.ejc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ejc.dao.EmployeeDao;
import com.ejc.entity.Employee;

@Controller
public class AppContoller {

	@Autowired
	EmployeeDao employeeDao;

	public AppContoller() {
		System.out.println("AppController !!! ");

	}

	@RequestMapping("/")
	public ModelAndView welcome() {

		System.out.println("Welcome Method get Called ");
		ModelAndView mav = new ModelAndView("home", "message", "Sucess !!!!!! Integration Done");
		return mav;
	}

	//

	@RequestMapping("/add_emp.html")
	public ModelAndView addEmp(@ModelAttribute Employee employee) {
		boolean status = false;
		String message = "";
		System.out.println("Data From UI -- AddEmployee Method " + employee);

		if (null == employee.getId()) {

			// code for Add
			status = employeeDao.addEmployee(employee);

			if (status) {
				message = "Add Sucessfull";
			} else {
				message = "Failled to Add";
			}

		} else {
			// code for Update
			// code for Add
			status = employeeDao.updateEmployee(employee);
			message = "";
			if (status) {
				message = "Update Sucessfull";
			} else {
				message = "Failled to Update ";
			}

		}

		List<Employee> list = employeeDao.listEmployee();

		Map<String, Object> model = new HashMap<>();
		model.put("message", message);
		model.put("employees", list);

		ModelAndView mav = new ModelAndView("home", model);

		System.out.println("AddController" + mav);

		return mav;
	}

	@RequestMapping("/pre.html")
	public ModelAndView getEmployeeBasedOnId(@ModelAttribute Employee employee1) {

		Employee employee = employeeDao.getEmployeeById(employee1.getId());
		List<Employee> list = employeeDao.listEmployee();

		Map<String, Object> model = new HashMap<>();
		model.put("emp", employee);
		model.put("employees", list);

		ModelAndView mav = new ModelAndView("home", model);

		return mav;
	}

	@RequestMapping("/delete.html")
	public ModelAndView deleteEmpl(@ModelAttribute Employee employee) {
		boolean removeStatus = employeeDao.removeEmployee(employee);
		String message = "";
		if (removeStatus) {
			message = "Delete  Sucessfull.";
		} else {
			message = "Failled to Delete.";
		}

		List<Employee> list = employeeDao.listEmployee();
		Map<String, Object> model = new HashMap<>();
		model.put("message", message);
		model.put("employees", list);
		ModelAndView mav = new ModelAndView("home", model);
		return mav;

	}

}
