package com.techgene.shiftAllocator.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class userShiftData {
	List<userShiftData> userShiftData  = new ArrayList<userShiftData>();
	public int getN() {
		return n;
	}
	int n=0;
	private String name;
	private String empId;
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	private Map<String,String> shifts = new HashMap<String, String>();
	private Map<String,String> weekOff = new HashMap<String, String>();
	public List<userShiftData> getUserShiftData() {
		return userShiftData;
	}
	public String getName() {
		return name;
	}
	public Map<String, String> getShifts() {
		return shifts;
	}
	public Map<String, String> getWeekOff() {
		return weekOff;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setShifts(Map<String, String> shifts) {
		this.shifts = shifts;
	}
	public void setWeekOff(Map<String, String> weekOff) {
		this.weekOff = weekOff;
	}
	public void insert(userShiftData obj){
		userShiftData.add(obj);
	}
	
	
}
