package com.ejc.dao;

import java.util.List;

import com.ejc.entity.Employee;

public interface IEmployee {

	

		public abstract boolean addEmployee(Employee employee);
		public abstract boolean updateEmployee(Employee employee);
		public abstract boolean removeEmployee(Employee employee);
		public abstract List<Employee> listEmployee();
		public abstract Employee getEmployeeById(Integer id);	}

