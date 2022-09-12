package com.java.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.java.spring.entity.Admin;
import com.java.spring.entity.Employee;
import com.java.spring.entity.Leaves;

/***
 * 
 * @author shusinha5
 * @Project Employee-Management
 * @Class Controller
 *
 */
@Controller
public class PortalController {

	@Autowired
	RestTemplate rt;

	/***
	 * 
	 * @return admin login page
	 */
	@GetMapping(value = "/admin/login")
	public String getAdminLoginPage() {
		return "adminLogin";
	}

	/***
	 * @Method Checking username and password
	 * @param username
	 * @param password
	 * @return Dashboard
	 */
	@PostMapping(value = "/admin/login")
	public ModelAndView giveAdminAcess(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		ModelAndView mv = new ModelAndView();
		ResponseEntity<Admin> admin = rt.getForEntity("http://localhost:9191/admin/login/" + username + "/" + password,
				Admin.class);
		if (admin.getStatusCodeValue() == 200) {
			mv.addObject("username", admin.getBody().getUsername());
			mv.setViewName("adminDashboard");
		} else if (admin.getStatusCodeValue() != 200) {
			String message = "Wrong Username Password";
			mv.addObject("message", message);
			mv.setViewName("failed");
			return mv;
		}
		return mv;

	}

	/**
	 * 
	 * @return Add Employee page
	 */
	@GetMapping(value = "/emp/add")
	public String getAddEmployeePage() {
		return "addEmployee";
	}

	/***
	 * @Method add Employee into db
	 * @param emp
	 * @return Employee
	 */
	@PostMapping(value = "/emp/added")
	public ModelAndView addEmployee(@ModelAttribute("emp") Employee emp) {
		ModelAndView mv = new ModelAndView();
		ResponseEntity<String> employee = rt.postForEntity("http://localhost:9192/emp/add", emp, String.class);
		mv.addObject(employee);
		mv.setViewName("listEmployee");
		String message = "Employee Added";
		mv.addObject("msg", message);
		return mv;
	}

	/***
	 * @method Listing Employee
	 * @return list of Employee
	 */
	@GetMapping(value = "/emp/list")
	public ModelAndView getListEmployeePage() {
		ModelAndView mv = new ModelAndView();
		ResponseEntity<List<Employee>> employees = rt.exchange("http://localhost:9192/emp/list", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Employee>>() {
				});
		mv.setViewName("listEmployee");
		mv.addObject("employees", employees.getBody());
		return mv;
	}

	/***
	 * @Method Get Employee Page
	 * @return Find Employee Page
	 */
	@GetMapping(value = "/emp/get")
	public String getEmployeeFindByIdPage() {
		return "findEmployee";
	}

	/***
	 * @Methid Get Employee by Id
	 * @param empId
	 * @return employee details
	 */
	@PostMapping(value = "/emp/get")
	public ModelAndView getEmployeeById(@RequestParam("empId") int empId) {
		ModelAndView mv = new ModelAndView();
		ResponseEntity<Employee> employee = rt.getForEntity("http://localhost:9192/emp/" + empId, Employee.class);
		mv.addObject("employee", employee.getBody());
		mv.setViewName("findEmployee");
		return mv;
	}

	/**
	 * 
	 * @return Add Employee page
	 */
	@GetMapping(value = "/leave/add")
	public ModelAndView getLeavePage(@RequestParam("empId") int empId, ModelMap map) {
		Leaves leaves = new Leaves();
		map.addAttribute(leaves);
		ModelAndView mv = new ModelAndView();
		ResponseEntity<Employee> employee = rt.getForEntity("http://localhost:9192/emp/" + empId, Employee.class);
		mv.addObject("employee", employee.getBody());
		mv.setViewName("addLeave");
		return mv;
	}

	/***
	 * @Method add Employee into db
	 * @param emp
	 * @return Employee
	 */
	@PostMapping(value = "/leave/added")
	public ModelAndView addLeave(@ModelAttribute("leave") Leaves leave, @RequestParam("empId") int empId) {
		ModelAndView mv = new ModelAndView();
		ResponseEntity<String> leaves = rt.postForEntity("http://localhost:9192/leave/add", leave, String.class);
		mv.addObject(leaves);
		mv.setViewName("success");
		String message = "Leave Added";
		mv.addObject("msg", message);
		return mv;
	}

	/**
	 * 
	 * @return View Leaves of employee
	 */
	@GetMapping(value = "emp/leave")
	public ModelAndView getEmployeeLeavePage(@RequestParam("empId") int empId, ModelMap map) {
		Leaves leaves = new Leaves();
		map.addAttribute(leaves);
		ModelAndView mv = new ModelAndView();
		ResponseEntity<List<Leaves>> employees = rt.exchange("http://localhost:9192/leave/" + empId, HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Leaves>>() {
				});
		ResponseEntity<Employee> emp = rt.getForEntity("http://localhost:9192/emp/" + empId, Employee.class);
		mv.addObject("emp", emp.getBody());
		mv.addObject("employees", employees.getBody());
		mv.setViewName("listLeaves");
		return mv;
	}

	/***
	 * @Method Employee leave approval
	 * @param leaveId
	 * @param map
	 * @return approved leave
	 */
	@GetMapping(value = "/leave/emp/approve")
	public ModelAndView aprooveEmployeeLeave(@RequestParam("leaveId") int leaveId, ModelMap map) {
		Leaves leaves = new Leaves();
		map.addAttribute(leaves);
		ModelAndView mv = new ModelAndView();
		ResponseEntity<Employee> emp = rt.getForEntity("http://localhost:9192/emp/leave/" + leaveId, Employee.class);
		mv.addObject("emp", emp.getBody());
		mv.setViewName("success");
		return mv;
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleError(Exception ex) {
		ex.printStackTrace();
		return ResponseEntity.status(404).body(ex.getMessage());

	}

}
