package com.techgene.shiftAllocator.model;



import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
@Component
public class ShiftDetails {
	
	private String dateStr;
	
	private String shiftCount;
	private String shiftOneCount;
	private String shiftTwoCount;
	private String shiftThreeCount;
	
	
	
	public String getDateStr() {
		return dateStr;
	}
	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}
	
	
	public String getShiftCount() {
		return shiftCount;
	}
	public void setShiftCount(String shiftCount) {
		this.shiftCount = shiftCount;
	}
	public String getShiftOneCount() {
		return shiftOneCount;
	}
	public void setShiftOneCount(String shiftOneCount) {
		this.shiftOneCount = shiftOneCount;
	}
	public String getShiftTwoCount() {
		return shiftTwoCount;
	}
	public void setShiftTwoCount(String shiftTwoCount) {
		this.shiftTwoCount = shiftTwoCount;
	}
	public String getShiftThreeCount() {
		return shiftThreeCount;
	}
	public void setShiftThreeCount(String shiftThreeCount) {
		this.shiftThreeCount = shiftThreeCount;
	}
	public String toString() {
		return "shiftCount: " + this.shiftCount + " shiftOneCount: " + this.shiftOneCount
				+ " shiftTwoCount : " + this.shiftTwoCount + " shiftThreeCount: " + this.shiftThreeCount+" Date: " + this.getDateStr();
	}
}
