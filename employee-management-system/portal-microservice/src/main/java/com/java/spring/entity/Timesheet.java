package com.java.spring.entity;

/***
 * 
 * @author shusinha5
 * @project Employee-Management
 * @Class Timesheet-Entity
 */
public class Timesheet {

	private int timesheetId;

	private int projectId;

	private int duration;

	private String date;

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
