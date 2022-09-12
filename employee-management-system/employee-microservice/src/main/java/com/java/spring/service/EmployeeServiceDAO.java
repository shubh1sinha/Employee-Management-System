package com.java.spring.service;

import java.util.List;
import java.util.Optional;

import com.java.spring.entity.Employee;
import com.java.spring.entity.Leaves;
import com.java.spring.entity.Salary;
import com.java.spring.entity.Timesheet;

/***
 * 
 * @author shubh-sinha
 * @Project Employee-Management
 * @Interface EmployeeServiceDAO
 *
 */

public interface EmployeeServiceDAO {
	public Employee findEmployee(String username);
	
	public List<Employee> listEmployee();

	public String getCurrentDate();

	public String getCurrentMonth();

	public Employee addEmployee(Employee emp);

	public boolean findByEmail(String email);

	public Employee updateEmployee(Employee emp);

	public Optional<Employee> findById(int id);

	public Timesheet addTimesheet(Timesheet timesheet);

	public List<Timesheet> listTimesheet();

	public Timesheet addEmployeeTimesheet(int empId, int timesheetId);

	public Salary addSalary(Salary salary);

	public List<Salary> listSalary();

	public Salary addEmployeeSalary(int empId, int slipId);
	
	public Leaves addLeave(Leaves leave);
	
	public List<Leaves> listAllLeaves(int empId);
	
	public Leaves approveLeaves(int leaveId);

}
