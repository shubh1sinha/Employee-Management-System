package com.java.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ADMIN")
public class Admin {
	
	@Id
	@Column(name="ADMINID")
	int adminId;
	
	@Column(name="USERNAME")
	String username;
	
	@Column(name="PASSWORD")
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
