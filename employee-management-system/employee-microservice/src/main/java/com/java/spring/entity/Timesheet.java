package com.java.spring.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/***
 * 
 * @author shubh-sinha
 * @project Employee-Management
 * @Class Timesheet-Entity
 *
 */
@Entity
@Table(name="TIMESHEET")
public class Timesheet {
	
	@Id
	@Column(name="TIMESHEETID")
	private int timesheetId;
	
	@Column(name="PROJECTID")
	private int projectId;
	
	@Column(name="DURATION")
	private int duration;
	
	@Column(name="DATE")
	private String date;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "EMPID", referencedColumnName = "EMPID")
	private Employee employee;

	public Timesheet() {
	}

	public Timesheet(int timesheetId, int projectId, int duration, String date) {
		this.timesheetId = timesheetId;
		this.projectId = projectId;
		this.duration = duration;
		this.date = date;
	}

	public int getTimesheetId() {
		return timesheetId;
	}

	public void setTimesheetId(int timesheetId) {
		this.timesheetId = timesheetId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void addEmployee(Employee emp) {
		this.employee = emp;
	}
	
	

}