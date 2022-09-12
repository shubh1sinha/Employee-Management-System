package com.java.spring.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/***
 * 
 * @author shusinha5
 * @Project Employee-Management
 * @Class Salary-Entity
 *
 */
@Entity
@Table(name = "SALARY")
public class Salary {

	@Id
	@Column(name = "SLIPID")
	private int slipId;

	@Column(name = "BASIC")
	private double basic;

	@Column(name = "DA")
	private double da;

	@Column(name = "HRA")
	private double hra;

	@Column(name = "SALARY")
	private double salary;

	@Column(name = "MONTH")
	private String month;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "EMPID", referencedColumnName = "EMPID")
	private Employee employee;

	public Salary() {
	}

	public Salary(int slipId, double basic, double da, double hra, double salary, String month) {
		this.slipId = slipId;
		this.basic = basic;
		this.da = da;
		this.hra = hra;
		this.salary = salary;
		this.month = month;
	}

	public int getSlipId() {
		return slipId;
	}

	public void setSlipId(int slipId) {
		this.slipId = slipId;
	}

	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
	}

	public double getDa() {
		return da;
	}

	public void setDa(double da) {
		this.da = da;
	}

	public double getHra() {
		return hra;
	}

	public void setHra(double hra) {
		this.hra = hra;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String string) {
		this.month = string;
	}

	public void addEmployee(Employee emp) {
		this.employee = emp;

	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	

}
