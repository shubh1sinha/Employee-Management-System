package com.java.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.spring.entity.Admin;
import com.java.spring.repo.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository adminRepo;
	
	public Admin findByUsername(String username) {
		Admin admin = adminRepo.findByUsername(username);
		return admin;
	}
	
	public List<Admin> listAll(){
		List<Admin> admin = adminRepo.findAll();
		return admin;
	}
}
