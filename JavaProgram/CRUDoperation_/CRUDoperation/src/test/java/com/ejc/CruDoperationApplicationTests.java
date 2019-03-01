package com.ejc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;

import com.ejc.controller.AppContoller;
import com.ejc.entity.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CruDoperationApplicationTests {
@Autowired
AppContoller appContoller;
@Autowired
	//@Test
	public void add() {
		
	Employee e=new Employee();
		e.setName("g");
		e.setPass("g");
	ModelAndView mav=	appContoller.addEmp(e);
	
	System.out.println(mav);
	
	}

@Test 
public void delete()
{
	Employee e=new Employee();
	e.setId(3);
	ModelAndView mav=appContoller.getEmployeeBasedOnId(e);
	System.out.println(mav);
	
} 
}

