package com.java.spring.entity;

/**
 * 
 * @author shubh-sinha
 * @Project Emp-Management
 * @Class Leaves Entity
 *
 */
public class Leaves {

	private int leaveId;

	private int EmpId;

	private int days;

	private String type;

	private String fromDate;

	private String toDate;

	private boolean status;

	public Leaves() {
	}

	public Leaves(int leaveId, int empId, int days, String type, String fromDate, String toDate, boolean status) {
		this.leaveId = leaveId;
		EmpId = empId;
		this.days = days;
		this.type = type;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.status = status;
	}

	public int getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}

	public int getEmpId() {
		return EmpId;
	}

	public void setEmpId(int empId) {
		EmpId = empId;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
