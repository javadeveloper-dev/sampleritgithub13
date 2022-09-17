package com.Model;

import java.util.*;
public class EmployeeModel {
   private int id;
   public String firstName;
   private String lastName;
   private String skills;
   private String age;
   private String salary;
   private  String dateOfJoining;
   
   
   public EmployeeModel(String firstName, String lastName, String skills, String age, String salary, String dateOfJoining) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.skills = skills;
		this.age = age;
		this.salary = salary;
		this.dateOfJoining = dateOfJoining;
	}
   
   public EmployeeModel(int id, String firstName, String lastName, String skills, String age, String salary, String dateOfJoining) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.skills = skills;
	this.age = age;
	this.salary = salary;
	this.dateOfJoining = dateOfJoining;
}



public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getfirstName() {
	return firstName;
}
public void setfirstName(String firstName) {
	this.firstName = firstName;
}
public String getlastName() {
	return lastName;
}
public void setlastName(String lastName) {
	this.lastName = lastName;
}
public String getSkills() {
	return skills;
}
public void setSkills(String skills) {
	this.skills = skills;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
public String getSalary() {
	return salary;
}
public void setSalary(String salary) {
	this.salary = salary;
}
public String getdateOfJoining() {
	return dateOfJoining;
}
public void setdateOfJoining(String dateOfJoining) {
	this.dateOfJoining = dateOfJoining;
}

@Override
public String toString() {
	return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", skills=" + skills
			+ ", age=" + age + ", salary=" + salary + ", dateOfJoining=" + dateOfJoining + "]";
}
   	
}
