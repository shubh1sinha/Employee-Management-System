package com.java.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.spring.entity.Salary;

public interface SalaryRepository extends JpaRepository<Salary, Integer> {

}
