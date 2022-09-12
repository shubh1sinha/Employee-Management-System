package com.java.spring.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.java.spring.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	public boolean existsByEmail(String email);

	public Employee findByEmail(String username);
}
