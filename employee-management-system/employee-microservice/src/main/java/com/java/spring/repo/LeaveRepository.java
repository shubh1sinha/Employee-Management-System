package com.java.spring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.spring.entity.Leaves;

public interface LeaveRepository extends JpaRepository<Leaves, Integer> {
	
	@Query("Select l from Leaves l where empId=?1")
	 public List<Leaves> getAllByEmployeeId(int empId);

}
