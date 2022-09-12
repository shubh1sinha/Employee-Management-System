package com.java.spring.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.spring.entity.Employee;
import com.java.spring.entity.Leaves;
import com.java.spring.entity.Salary;
import com.java.spring.entity.Timesheet;
import com.java.spring.repo.EmployeeRepository;
import com.java.spring.repo.LeaveRepository;
import com.java.spring.repo.SalaryRepository;
import com.java.spring.repo.TimesheetRepository;
/***
 * 
 * @author shubh-sinha
 * @Project Employee-Management
 * @Class EmployeeService Implementation
 */
@Service
public class EmployeeService implements EmployeeServiceDAO {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private TimesheetRepository timeRepo;
	
	@Autowired 
	private SalaryRepository salaryRepo;
	
	@Autowired
	private LeaveRepository leaveRepo;

	@Override
	public List<Employee> listEmployee() {
		return empRepo.findAll();
	}

	@Override
	/***
	 * @Method Get current month 
	 *        from localdate
	 */
	public String getCurrentMonth() {
		LocalDate localdate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM");
		return localdate.format(formatter);
	}
	
	@Override
	/**
	 * @Method Grtting Local date 
	 *       in ISO format
	 */
	public String getCurrentDate() {
		LocalDate localdate = LocalDate.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE;
		return localdate.format(dateTimeFormatter);
	}

	@Override
	/***
	 * @Method Add employee
	 *      in db
	 * @param Employee
	 */
	public Employee addEmployee(Employee emp) {
		emp.setJoining(getCurrentDate());
		return empRepo.save(emp);
	}

	@Override
	/***
	 * @Method Check Employee
	 * 		existing by email
	 * @param Email
	 */
	public boolean findByEmail(String email) {
		if (empRepo.existsByEmail(email)) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	/***
	 * @method Update employee
	 * @param Employee
	 */
	public Employee updateEmployee(Employee emp) {
			emp.setJoining(emp.getJoining());
			return empRepo.save(emp);
		
	}

	@Override
	/***
	 * @method Get Employee by Id
	 * @param Id
	 */
	public Optional<Employee> findById(int id) {
		Optional<Employee> emp  = empRepo.findById(id);
		return emp;
	}

	@Override
	/***
	 * @Method Add timesheet
	 *       to database
	 * @param Timesheet
	 */
	public Timesheet addTimesheet(Timesheet timesheet) {
		timesheet.setDate(getCurrentDate());
		return timeRepo.save(timesheet);
	}

	@Override
	/***
	 * @method List All employees 
	 *     timesheet
	 */
	public List<Timesheet> listTimesheet() {
		return timeRepo.findAll();
		}

	@Override
	/***
	 * @Method Assign timesheet
	 *      to employee
	 * @param empId, timesheetId
	 */
	public Timesheet addEmployeeTimesheet(int empId, int timesheetId) {
		Employee emp = empRepo.findById(empId).get();
		Timesheet timesheet = timeRepo.findById(timesheetId).get();
		timesheet.addEmployee(emp);
		return timeRepo.save(timesheet);
	}

	@Override
	/***
	 * @method Add Salary
	 * @param Salary
	 */
	public Salary addSalary(Salary salary) {
		salary.setMonth(getCurrentMonth());
		salary.setSalary(salary.getBasic() + salary.getDa() +salary.getHra());
		return salaryRepo.save(salary);
	}

	@Override
	/**
	 * @Method List All Salary
	 *     of Employees 
	 */
	public List<Salary> listSalary() {
		return salaryRepo.findAll();
	}

	@Override
	/**
	 * @Method Add Employee Salary
	 * @param empId, slipId
	 */
	public Salary addEmployeeSalary(int empId, int slipId) {
		Employee emp = empRepo.findById(empId).get();
		Salary salary = salaryRepo.findById(slipId).get();
		salary.addEmployee(emp);
		return salaryRepo.save(salary);
	}

	@Override
	/**
	 * @Method Add Employee Leaves
	 * @param Leaves
	 */
	public Leaves addLeave(Leaves leave) {
		return leaveRepo.save(leave);
	}
	
	@Override
	/**
	 * @method List leaves of
	 * 		all Employee
	 */
	public List<Leaves> listAllLeaves(int empId){
		return leaveRepo.getAllByEmployeeId(empId);
	}

	/***
	 * @methid find Employee using username
	 */
	@Override
	public Employee findEmployee(String username) {
		return empRepo.findByEmail(username);
	}

	@Override
	public Leaves approveLeaves(int leaveId) {
		// TODO Auto-generated method stub
		Leaves emp = leaveRepo.findById(leaveId).get();
		emp.setStatus(true);
		return leaveRepo.save(emp);
		
	}

	
	
	

}
