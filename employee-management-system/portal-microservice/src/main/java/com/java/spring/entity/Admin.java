package com.java.spring.entity;

/***
 * 
 * @author shusinha5
 * @Project Emp-Management
 * @Class Admin Entity
 * 
 */
public class Admin {

	int adminId;

	String username;

	String password;

	public Admin() {
	}

	public Admin(int adminId, String username, String password) {
		this.adminId = adminId;
		this.username = username;
		this.password = password;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
