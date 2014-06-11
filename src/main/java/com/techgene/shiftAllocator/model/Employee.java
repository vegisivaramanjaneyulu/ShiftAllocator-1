package com.techgene.shiftAllocator.model;

import java.util.Date;

public class Employee {

	private String empName;
	private String empID;
	private String shift;
	private String weekOff;
	private String year;
	private String month;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public void setMonth(String month) {
		this.month = month;
	}
	public String getMonth() {
		return month;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public String getWeekOff() {
		return weekOff;
	}

	public void setWeekOff(String weekOff) {
		this.weekOff = weekOff;
	}

	

	public String toString() {
		return "Name: " + this.empName + " Shift: " + this.shift
				+ " holiday on: " + this.weekOff + " For Month: " + this.month+" For Year: " + this.year;
	}

}
