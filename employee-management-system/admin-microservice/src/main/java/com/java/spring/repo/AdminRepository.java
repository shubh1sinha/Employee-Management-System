package com.java.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.spring.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	
	Admin findByUsername(String username);

}
