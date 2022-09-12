package com.java.spring.entity;

import java.util.HashSet;
import java.util.Set;


/***
 * 
 * @author shusinha5
 * @Project Employee-Management
 * @Class Employee-Entity
 *
 */
public class Employee {
	
	private int empId;
	
	private String name;
	
	private String email;
	
	private String  password;
	
	private double ctc;
	
	private String joining;
	
	private String department;
	
	private Set<Timesheet> timesheet = new HashSet<>();

	private Set<Salary> salarySlip = new HashSet<>();

	public Employee() {
	}

	public Employee(int empId, String name, String email, String password, double ctc, String joining,
			String department) {
		this.empId = empId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.ctc = ctc;
		this.joining = joining;
		this.department = department;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getSalary() {
		return ctc;
	}

	public void setSalary(double ctc) {
		this.ctc = ctc;
	}

	public String getJoining() {
		return joining;
	}

	public void setJoining(String joining) {
		this.joining = joining;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Set<Timesheet> getTimesheet() {
		return timesheet;
	}

	public void setTimesheet(Set<Timesheet> timesheet) {
		this.timesheet = timesheet;
	}

	public Set<Salary> getSalarySlip() {
		return salarySlip;
	}

	public void setSalarySlip(Set<Salary> salarySlip) {
		this.salarySlip = salarySlip;
	}
}
