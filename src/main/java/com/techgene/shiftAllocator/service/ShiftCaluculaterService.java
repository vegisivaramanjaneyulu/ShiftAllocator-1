package com.techgene.shiftAllocator.service;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;

import com.techgene.shiftAllocator.DAO.ShiftCaluculaterDAO;
import com.techgene.shiftAllocator.controller.WebLoginLogoffController;
import com.techgene.shiftAllocator.dto.userShiftData;
import com.techgene.shiftAllocator.model.Employee;
import com.techgene.shiftAllocator.model.ShiftDetails;

@Service
public class ShiftCaluculaterService {

	private Logger logger = LoggerFactory
			.getLogger(ShiftCaluculaterService.class);
	@Autowired
	ShiftCaluculaterDAO shiftCaluculateDAO;

	private Random rand = new Random();
	private String users[] = {};
	private String[] holidays = { "monday", "tuesday", "wednesday", "thursday",
			"friday", "saturday", "sunday" };
	private int[] shiftsCapacity;
	private String[] shifts;
	private String month = "";
	private String year = "";
	private Map<String, ArrayList<String>> holiday = new HashMap<String, ArrayList<String>>();
	private Map<String, String> empHoliday = new HashMap<String, String>();
	private Map<String, Integer> shiftMap = new HashMap<String, Integer>();

	private Map<String, ArrayList<Employee>> employeeDetails = new HashMap<String, ArrayList<Employee>>();

	/**
	 * planShifts.
	 * 
	 * @param shiftDetails
	 * @param request
	 * @exception UnknownHostException
	 * @return
	 */

	public HttpServletRequest planShifts(ShiftDetails shiftDetails,HttpServletRequest request)
			throws UnknownHostException {

		logger.info(">> planShifts");

		Boolean flag1=true;
		Boolean flag2=false;
	
		request.setAttribute("flag1", flag1);
		request.setAttribute("flag2", flag2);
		int shiftStrengthSum=0;
		int docCount=0;
		int empCount=0;
		
		empCount=initializeData(shiftDetails);
		request.setAttribute("empCount", empCount);
		for(int y=0;y<shiftsCapacity.length;y++){
			shiftStrengthSum=shiftStrengthSum+shiftsCapacity[y];
				}
		if(shiftStrengthSum !=empCount ){
			flag1=false;
			request.setAttribute("flag1", flag1);
			
			shiftMap.clear();
			empHoliday.clear();
			holiday.clear();
			return request;
		}
		if(empCount!=0){
		calcFirstShift();
		docCount= saveCollection();

		if(empCount==docCount && empCount!=0 && docCount!=0){
	    	
	    	flag2=true;
	    	request.setAttribute("flag2", flag2);
	    	
	       }
		
		
		shiftMap.clear();
		empHoliday.clear();
		holiday.clear();
		}

       
	return request;

	}

	/**
	 * initializeData.
	 * 
	 * @param shiftDetails
	 * 
	 * 
	 * @return
	 */

	private int initializeData(ShiftDetails shiftDetails) {

		logger.info(">> initializeData");

		String dt = shiftDetails.getDateStr();
		String[] data = dt.split("-");
		year = data[0];
		month = data[1];

		List<String> empNames = shiftCaluculateDAO.getEmpNames();
		String[] names = new String[empNames.size()];

		names = empNames.toArray(names);
		users = names;
		int shiftCount = Integer.parseInt(shiftDetails.getShiftCount());
		int empCount=0;
		if(shiftCount!=0){
		empCount=users.length;
		
		shiftsCapacity=new int[shiftCount];
		shifts=new String[shiftCount];
		if(shiftCount==1){
			shiftsCapacity[0]=Integer.parseInt(shiftDetails.getShiftOneCount());
			shifts[0]="Morning";
		}
		else if(shiftCount==2){
			shifts[0]="Morning";
			shifts[1]="Evening";
			
			shiftsCapacity[0]=Integer.parseInt(shiftDetails.getShiftOneCount());
			shiftsCapacity[1]=Integer.parseInt(shiftDetails.getShiftTwoCount());
			}
		else if(shiftCount==3){
			shifts[0]="Morning";
			shifts[1]="Evening";
			shifts[2]="Night";
			shiftsCapacity[0]=Integer.parseInt(shiftDetails.getShiftOneCount());
			shiftsCapacity[1]=Integer.parseInt(shiftDetails.getShiftTwoCount());
			shiftsCapacity[2]=Integer.parseInt(shiftDetails.getShiftThreeCount());
			
		}
		}

		return empCount;

	}

	/**
	 * saveCollection.
	 * 
	 * @param shiftDetails
	 * 
	 * @exception UnknownHostException
	 * 
	 * @return
	 */

	private int saveCollection() throws UnknownHostException {

		logger.info(">> saveCollection");

		int docCount = 0;

		String empName = "";
		String year = "";
		String month = "";
		String shift = "";
		String weekOff = "";

		Iterator itr = employeeDetails.entrySet().iterator();
		while (itr.hasNext()) {

			BasicDBObject doc = new BasicDBObject();
			Map.Entry entry = (Map.Entry) itr.next();
			ArrayList objList = (ArrayList) entry.getValue();
			Employee emp = (Employee) objList.get(0);

			empName = emp.getEmpName();
			year = emp.getYear();
			month = emp.getMonth();
			shift = emp.getShift();
			weekOff = emp.getWeekOff();
			Map<String, BasicDBObject> shiftHoliday = new HashMap<String, BasicDBObject>();
			BasicDBObject shiftDoc = new BasicDBObject();
			BasicDBObject holidayDoc = new BasicDBObject();
			shiftDoc.append("week1", shift);
			holidayDoc.append("week1", weekOff);

			shiftHoliday.put("shift", shiftDoc);

			shiftHoliday.put("holiday", holidayDoc);

			shiftCalForWeek2(shiftHoliday);
			shiftCalForWeek3(shiftHoliday);
			shiftCalForWeek4(shiftHoliday);

			Iterator iterator = empHoliday.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry val = (Map.Entry) iterator.next();

				
			}

			shiftDoc = shiftHoliday.get("shift");
			holidayDoc = shiftHoliday.get("holiday");

			doc.append("empname", empName).append("month", month)
					.append("year", year).append("shift", shiftDoc)
					.append("weekoff", holidayDoc);
			int res = shiftCaluculateDAO.saveShiftData(doc, month, docCount);
			if (res == 1) {
				docCount++;
			}

		}
		return docCount;
	}

	/**
	 * shiftCalForWeek4.
	 * 
	 * @param shiftHoliday
	 * 
	 * @exception UnknownHostException
	 * 
	 * @return
	 */

	private void shiftCalForWeek4(Map<String, BasicDBObject> shiftHoliday) {

		logger.info(">> shiftCalForWeek4");

		BasicDBObject shiftDoc = shiftHoliday.get("shift");
		BasicDBObject holidayDoc = shiftHoliday.get("holiday");
		String shift = shiftDoc.getString("week1");
		String weekOff = holidayDoc.getString("week1");

		shiftDoc.append("week4", shift);
		holidayDoc.append("week4", weekOff);
		shiftHoliday.put("shift", shiftDoc);
		shiftHoliday.put("holiday", holidayDoc);
	}

	/**
	 * shiftCalForWeek3.
	 * 
	 * @param shiftHoliday
	 * 
	 * @exception UnknownHostException
	 * 
	 * @return
	 */
	private void shiftCalForWeek3(Map<String, BasicDBObject> shiftHoliday) {

		logger.info(">> shiftCalForWeek3");

		BasicDBObject shiftDoc = shiftHoliday.get("shift");
		BasicDBObject holidayDoc = shiftHoliday.get("holiday");
		String shift = shiftDoc.getString("week2");
		String weekOff = holidayDoc.getString("week2");
		String nextshift2 = changeShift(shift);
		String weekOf1 = weekOff.split(" and ")[1];
		String weekOf2 = changeHoliday(weekOf1);
		
		String netWeekOf = weekOf1 + " and " + weekOf2;
		shiftDoc.append("week3", nextshift2);
		holidayDoc.append("week3", netWeekOf);
		shiftHoliday.put("shift", shiftDoc);
		shiftHoliday.put("holiday", holidayDoc);
	}

	/**
	 * shiftCalForWeek2.
	 * 
	 * @param shiftHoliday
	 * 
	 * @exception UnknownHostException
	 * 
	 * @return
	 */
	private void shiftCalForWeek2(Map<String, BasicDBObject> shiftHoliday) {

		logger.info(">> shiftCalForWeek2");

		BasicDBObject shiftDoc = shiftHoliday.get("shift");
		BasicDBObject holidayDoc = shiftHoliday.get("holiday");
		String shift = shiftDoc.getString("week1");
		String weekOff = holidayDoc.getString("week1");

		String nextshift1 = changeShift(shift);

		String weekOff1 = weekOff.split(" and ")[1];
		String weekOff2 = changeHoliday(weekOff1);

		String netWeekOff = weekOff1 + " and " + weekOff2;
		shiftDoc.append("week2", nextshift1);
		holidayDoc.append("week2", netWeekOff);
		shiftHoliday.put("shift", shiftDoc);
		shiftHoliday.put("holiday", holidayDoc);
	}

	/**
	 * changeHoliday.
	 * 
	 * @param weekOff
	 * 
	 * @exception UnknownHostException
	 * 
	 * @return
	 */

	private String changeHoliday(String weekOff) {

		logger.info(">> changeHoliday");

		String nextWeekOff = "";

		for (int i = 0; i < holidays.length; i++) {
			if (holidays[i].equals(weekOff)) {
				if (i < holidays.length - 1) {
					nextWeekOff = holidays[i + 1];

				} else {
					if (i == holidays.length - 1) {
						nextWeekOff = holidays[0];
					} else {
						nextWeekOff = holidays[1];
					}
				}
			}
		}
		return nextWeekOff;

	}

	/**
	 * changeShift.
	 * 
	 * @param shift
	 * 
	 * @exception UnknownHostException
	 * 
	 * @return
	 */

	private String changeShift(String shift) {

		logger.info(">> changeShift");

		String nextShift = "";
		for (int i = 0; i < shifts.length; i++) {
			if (shifts[i].equals(shift)) {
				if (i < shifts.length - 1) {
					nextShift = shifts[i + 1];
				} else {
					if (i == shifts.length - 1) {
						nextShift = shifts[0];
					} else {
						nextShift = shifts[i - 1];
					}
				}
			}
		}
		return nextShift;

	}

	/**
	 * calcFirstShift.
	 * 
	 * 
	 * @exception UnknownHostException
	 * 
	 * @return
	 */

	private void calcFirstShift() {

		logger.info(">> calcFirstShift");

		for (int k = 0; k < users.length; k++) {
			ArrayList<Employee> list = new ArrayList<Employee>();

			Employee emp = new Employee();
			emp.setEmpName(users[k]);
			emp.setMonth(month);
			emp.setYear(year);

			getRandomShift(users[k], shiftsCapacity, emp);
			list.add(emp);
			employeeDetails.put(users[k], list);

		}

	}

	/**
	 * getRandomShift.
	 * 
	 * @param username
	 * @param shiftsCapacity
	 * @exception UnknownHostException
	 * 
	 * @return
	 */

	private void getRandomShift(String username, int[] shiftsCapacity,
			Employee emp) {

		logger.info(">> getRandomShift");

		int randomShift = rand.nextInt(shifts.length);
		String shift = shifts[randomShift];
		Integer key = shiftsCapacity[randomShift];
		if (!shiftMap.containsKey(shift)) {
			shiftMap.put(shift, 1);
			String day = getRandomHoliday(shift, key, username);
			emp.setShift(shift);
			emp.setWeekOff(day);
			// return shift;
		} else if (shiftMap.get(shift) < key) {
			shiftMap.put(shift, shiftMap.get(shift) + 1);
			String day = getRandomHoliday(shift, key, username);
			emp.setShift(shift);
			emp.setWeekOff(day);
		} else
			getRandomShift(username, shiftsCapacity, emp);
	}

	/**
	 * getRandomHoliday.
	 * 
	 * @param shift
	 * @param key
	 * @param username
	 * @exception UnknownHostException
	 * 
	 * @return
	 */

	private String getRandomHoliday(String shift, int key, String username) {

		logger.info(">> getRandomHoliday");

		int randomDay = rand.nextInt(holidays.length);
		String day1 = holidays[randomDay];
		String day2 = "";
		int dayCount = 0;
		if (holiday.get(shift) != null) {

			dayCount = Collections.frequency(holiday.get(shift), day1);

		}

		if (randomDay < holidays.length - 1) {
			randomDay = randomDay + 1;
		} else {
			randomDay = 0;
		}

		day2 = holidays[randomDay];

		ArrayList<String> holidayList = new ArrayList<String>();

		if (!holiday.containsKey(shift)) {
			empHoliday.put(username, shift + "\t\t" + day1 + " and " + day2);
			holidayList.add(day1);
			holiday.put(shift, holidayList);
			return day1 + " and " + day2;
		} else if (dayCount <= holidays.length / 2
				&& holiday.get(shift).size() <= key) {
			empHoliday.put(username, shift + "\t\t" + day1 + " and " + day2);
			holidayList = holiday.get(shift);
			holidayList.add(day1);
			holiday.put(shift, holidayList);
			return day1 + " and " + day2;
		} else
			return getRandomHoliday(shift, key, username);
	}

	/**
	 * getShiftsDataOfMonth.
	 * 
	 * @param month
	 * @param userName
	 * @param userType
	 * @exception UnknownHostException
	 * 
	 * @return
	 */


	
	public userShiftData getShiftsDataOfMonth(String month,String userName,String userType) {
		
		logger.info(">> getShiftsDataOfMonth");
		
		userShiftData cursor=shiftCaluculateDAO.getShiftDataOfMonth(month,userName,userType);
		return cursor;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
