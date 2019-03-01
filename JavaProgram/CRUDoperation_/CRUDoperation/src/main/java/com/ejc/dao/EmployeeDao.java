package com.ejc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ejc.MySqlConnection.MySql;
import com.ejc.entity.Employee;
@Repository
public class EmployeeDao implements IEmployee {
public EmployeeDao() {
		System.out.println("EmployeeDao --  Constructor ");
	}
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	@Override
	public boolean addEmployee(Employee employee) {

		boolean addStatus = false;
		con = MySql.mysqlConn();
		String sqlQuery = "insert into employee(name,pass) values (?,?)";
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, employee.getName());
			ps.setString(2,employee.getPass());

			System.out.println("Query Generated " + ps);

			int rowA = ps.executeUpdate();

			if (rowA > 0) {
				addStatus = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return addStatus;
	}

	@Override
	public  boolean updateEmployee(Employee employee){
System.out.println("update employee");
		boolean updateStatus = false;
		con = MySql.mysqlConn();
		String sqlQuery = "update employee set name=? ,pass=? where id=?";
		try {
			ps = con.prepareStatement(sqlQuery);

			ps.setString(1, employee.getName());
			ps.setString(2, employee.getPass());
			ps.setInt(3, employee.getId());
		
			System.out.println("Query Generated " + ps);

			int rowA = ps.executeUpdate();

			if (rowA > 0) {
				updateStatus = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return updateStatus;
	}

	@Override
	public boolean removeEmployee(Employee employee) {
		boolean removeStatus = false;
		con = MySql.mysqlConn();
		String sqlQuery = "delete from  employee  where id=?";
		try {
			ps = con.prepareStatement(sqlQuery);

			ps.setInt(1, employee.getId());
			System.out.println("Query Generated " + ps);

			int rowA = ps.executeUpdate();

			if (rowA > 0) {
				removeStatus = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return removeStatus;
	}

	@Override
	public List<Employee> listEmployee() {

		List<Employee> list = new ArrayList<>();
		con = MySql.mysqlConn();
		String sqlQuery = "select id,name ,pass from employee";
		try {
			ps = con.prepareStatement(sqlQuery);
			System.out.println("Query Generated " + ps);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String pass=rs.getString("pass");
						
Employee employee = new Employee(id, name,pass);
				list.add(employee);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		Employee employee = null;
		con = MySql.mysqlConn();
		String sqlQuery = "select id,name,pass from employee where id=?";
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setLong(1, id);
			
			System.out.println("Query Generated " + ps);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Integer id1 = rs.getInt("id");
				String name = rs.getString("name");
				String pass=rs.getString("pass");
				employee = new Employee(id, name,pass);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return employee;
	}

	
}

