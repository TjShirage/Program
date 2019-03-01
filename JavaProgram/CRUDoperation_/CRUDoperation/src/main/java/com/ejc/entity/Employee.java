package com.ejc.entity;

public class Employee {
private Integer id;
private String name;
private String pass;
public Employee(Integer id, String name, String pass) {
	super();
	this.id = id;
	this.name = name;
	this.pass = pass;
}
public Employee(String name, String pass) {
	super();
	this.name = name;
	this.pass = pass;
}
@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", pass=" + pass + "]";
}
public Employee() {
	System.out.println("Employee onstrutor");
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
}
