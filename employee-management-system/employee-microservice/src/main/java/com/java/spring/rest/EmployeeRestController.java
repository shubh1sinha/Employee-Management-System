package com.java.spring.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.java.spring.entity.Employee;
import com.java.spring.entity.Leaves;
import com.java.spring.entity.Salary;
import com.java.spring.entity.Timesheet;
import com.java.spring.service.EmployeeService;

/***
 * 
 * @author shubh-sinha
 * @Project Employee Management System
 * @Class RestController
 *
 */

@RestController
public class EmployeeRestController {

	@Autowired
	private EmployeeService empService;

	/***
	 * @Method Employee Login
	 * @param username
	 * @param password
	 * @return employee
	 */
	@GetMapping(value = "/employee/login/{username}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> accessEmployee(@PathVariable("username") String username,
			@PathVariable("password") String password) {
		Employee employee = empService.findEmployee(username);
		if (employee.getEmail().equals(username) && employee.getPassword().equals(password)) {
			return ResponseEntity.status(200).body(employee);
		} else {
			return ResponseEntity.status(201).body("{\"status\":\"Admin not found\"}");
		}

	}

	/***
	 * @Method add employee
	 * @param emp
	 * @return response status
	 */
	@PostMapping(value = "/emp/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addEmployee(@RequestBody Employee emp) {
		if (empService.findByEmail(emp.getEmail())) {
			return ResponseEntity.status(404).body("{\"status\":\"Employee Already There..\"}");
		} else {
			empService.addEmployee(emp);
			return ResponseEntity.status(200).body("{\"status\":\"Added Successfully.\"}");
		}

	}

	/***
	 * @Method update employee
	 * @param emp
	 * @return response status
	 */
	@PostMapping(value = "/emp/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updatePatient(@RequestBody Employee emp) {
		if (empService.findByEmail(emp.getEmail())) {
			empService.updateEmployee(emp);
			return ResponseEntity.ok("{\"status\":\"Employee Updated.\"}");
		} else {
			return ResponseEntity.status(404).body("{\"status\":\"Employee Not Present..\"}");
		}

	}

	/***
	 * @Method list all employee
	 * @return list of employee
	 */
	@GetMapping(value = "/emp/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> findAllEmployee() {
		return empService.listEmployee();
	}

	/**
	 * @Method Find Employee by Id
	 * @param id
	 * @return employee
	 */
	@GetMapping(value = "/emp/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Employee> findAllCustomer(@PathVariable int id) {
		return empService.findById(id);
	}

	/***
	 * @Method Add timesheet to db
	 * @param timesheet
	 * @return response status
	 */
	@PostMapping(value = "/timesheet/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addTimesheet(@RequestBody Timesheet timesheet) {
		empService.addTimesheet(timesheet);
		return ResponseEntity.status(200).body("{\"status\":\"Added Successfully.\"}");

	}

	/***
	 * @Method list all timesheet
	 * @return list of timesheet
	 */
	@GetMapping(value = "/timesheet/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Timesheet> findTimesheet() {
		return empService.listTimesheet();
	}

	/***
	 * @Method Assign timesheet to employee
	 * @param empId
	 * @param timesheetId
	 * @return employee with joined timesheet
	 */
	@GetMapping(value = "/emp/{empId}/timesheet/{timesheetId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Timesheet addEmployeeTimesheet(@PathVariable("empId") int empId,
			@PathVariable("timesheetId") int timesheetId) {
		return empService.addEmployeeTimesheet(empId, timesheetId);
	}

	/***
	 * @Method Add Salary to db
	 * @param salary
	 * @return response status
	 */
	@PostMapping(value = "/salary/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addSalary(@RequestBody Salary salary) {
		empService.addSalary(salary);
		return ResponseEntity.status(200).body("{\"status\":\"Added Successfully.\"}");
	}

	/***
	 * @Method List all salary
	 * @return list of salary
	 */
	@GetMapping(value = "/salary/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Salary> listSalay() {
		return empService.listSalary();
	}

	/***
	 * @Method Assign salary to employee
	 * @param empId
	 * @param salipId
	 * @return employee after joining salary
	 */
	@GetMapping(value = "/emp/{empId}/salary/{salipId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Salary addEmployeeSalaty(@PathVariable("empId") int empId, @PathVariable("salipId") int salipId) {
		return empService.addEmployeeSalary(empId, salipId);
	}

	/***
	 * @Method add leaves
	 * @param leaves
	 * @return response status
	 */
	@PostMapping(value = "/leave/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addLeaves(@RequestBody Leaves leave) {
		empService.addLeave(leave);
		return ResponseEntity.status(200).body("{\"status\":\"Added Successfully.\"}");
	}

	/***
	 * @Method get leaves of Employee
	 * @param empId
	 * @return list of leaves by Employee
	 */
	@GetMapping(value = "/leave/{empId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Leaves> getLeavesofEmployee(@PathVariable("empId") int empId) {
		return empService.listAllLeaves(empId);
	}
	
	/***
	 * @Method Approve leave
	 * @param leaveId
	 * @return leaves
	 */
	@GetMapping(value = "/emp/leave/{leaveId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Leaves approveEmployeeLeave(@PathVariable("leaveId") int leaveId) {
		return empService.approveLeaves(leaveId);
	}
	
}
