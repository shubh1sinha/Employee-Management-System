package com.java.spring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.java.spring.entity.Admin;
import com.java.spring.service.AdminService;

/***
 * 
 * @author shusinha5
 * @Project Employee-Management
 * @Class Admin RestController
 *
 */
@RestController
public class AdminRestController {

	@Autowired
	private AdminService adminService;

	/**
	 * 
	 * @Method AccessAdmin
	 * @param username
	 * @param password
	 * @return admin login/ failed
	 * 
	 */
	@GetMapping(value = "/admin/login/{username}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> accessAdmin(@PathVariable("username") String username,
			@PathVariable("password") String password) {
		Admin admin = adminService.findByUsername(username);
		if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
			return ResponseEntity.status(200).body(admin);
		} else {
			return ResponseEntity.status(201).body("{\"status\":\"Admin not found\"}");
		}

	}
	
    /***
     * @Methid Listing Admins
     * @return list of all admins
     */
	@GetMapping(value = "admin/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Admin> listAll() {
		return adminService.listAll();
	}

}
