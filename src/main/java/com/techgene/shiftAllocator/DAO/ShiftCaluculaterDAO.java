package com.techgene.shiftAllocator.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import com.techgene.shiftAllocator.dto.userShiftData;
import com.techgene.shiftAllocator.service.ShiftCaluculaterService;

@Repository
public class ShiftCaluculaterDAO {
	@Autowired
	MongoTemplate mongoTemplate;

	private Logger logger = LoggerFactory.getLogger(ShiftCaluculaterDAO.class);

	public List<String> getEmpNames() {
		List<String> empNames = new ArrayList<String>();

		DBCollection userCollection = mongoTemplate.getCollection("user");
		DBCursor cur = userCollection.find();

		while (cur.hasNext()) {

			String name = (String) cur.next().get("userName");
			empNames.add(name);

		}
		return empNames;
	}

	public int saveShiftData(BasicDBObject doc, String month, int docCount) {
		int flag = 0;
		DBCursor cursor = null;
		WriteResult res = null;
		DBCollection userCollection = mongoTemplate.getCollection("shiftData");
		;
		if (docCount == 0) {
			cursor = userCollection.find(new BasicDBObject("month", month));
			if (!cursor.hasNext()) {
				res = userCollection.insert(doc);
			}
		} else {
			res = userCollection.insert(doc);

		}

		if (res != null && res.getN() != 1) {
			flag = 1;
		}
		return flag;
		// res.getN() == 1 ? 0 : 1;
	}

	/**
	 * getShiftDataOfMonth.
	 * 
	 * @param month
	 * @param userName
	 * @param userType
	 * @ResponseBody userShiftData[]
	 */

	public userShiftData getShiftDataOfMonth(String month, String userName,
			String userType) {
	
		logger.info(">> getShiftDataOfMonth ");
		
		DBCollection shiftCollection = mongoTemplate.getCollection("shiftData");
		BasicDBObject monthQuery = new BasicDBObject();
		monthQuery.put("month", month);
		if (userType.equals("Employee")) {
			monthQuery.put("empname", userName);
		}

		DBCursor montCursor = shiftCollection.find(monthQuery);

		
		userShiftData actualObj = null;
		if (montCursor.hasNext()) {
			actualObj = new userShiftData();
		}
		while (montCursor.hasNext()) {

			DBObject document = montCursor.next();
			
			String name = (String) document.get("empname");
			Map<String, String> shifts = (Map<String, String>) document
					.get("shift");
			Map<String, String> weekOff = (Map<String, String>) document
					.get("weekoff");
			userShiftData obj = new userShiftData();
			obj.setName(name);
			obj.setShifts(shifts);
			obj.setWeekOff(weekOff);
			actualObj.insert(obj);

		}
		return actualObj;
	}
}
