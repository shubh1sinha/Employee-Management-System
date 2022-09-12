package com.java.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.spring.entity.Timesheet;

public interface TimesheetRepository extends JpaRepository<Timesheet, Integer> {

}
