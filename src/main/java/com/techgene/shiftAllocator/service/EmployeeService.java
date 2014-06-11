package com.techgene.shiftAllocator.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.techgene.shiftAllocator.model.User;
import com.techgene.shiftAllocator.model.UserRepository;

@Service
public class EmployeeService {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private UserRepository userRepository;

	private Logger logger = LoggerFactory.getLogger(EmployeeService.class);

	/**
	 * registerUser This method stores user details enter in form into mongodb
	 * under user collection
	 * 
	 * 
	 * 
	 * @param user
	 * @return
	 */

	public User registerUser(User user) {

		logger.info("registerUser");

		user.setId(UUID.randomUUID().toString());

		return userRepository.save(user);
	}

	/**
	 * This method stores default user credentials to login
	 * 
	 * 
	 * 
	 */

	public void init() {

		mongoTemplate.dropCollection("user");

		User user = new User();

		user.setId(UUID.randomUUID().toString());
		user.setUserName("sivaram");
		user.setPassword("hadoop123");

		user.setUserType("TeamLeader");
		user.setEmail("vegi.sivaram@gmail.com");
		user.setName("vegisivaram");
		user.setEmpId("1");

		mongoTemplate.insert(user, "user");

	}

	/**
	 * validateCredentials This method is for to validate credentials
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */

	public Boolean validateCredentials(String userName, String password,
			String userType) {

		logger.info("validateCredentials");

		Boolean status = true;
		try {
			DBCollection userDetails = mongoTemplate.getCollection("user");

			DBObject credentials = userDetails.findOne(new BasicDBObject(
					"userName", userName).append("password", password).append(
					"userType", userType));

			if (credentials == null) {
				status = false;
			}
		} catch (Exception e) {
			status = false;
			// TODO: handle exception
		}
		return status;

	}

	public Boolean validateUser(String userName) {

		logger.info("validateUser");

		Boolean status = true;

		try {
			DBCollection userDetails = mongoTemplate.getCollection("user");

			DBObject validUser = userDetails.findOne(new BasicDBObject(
					"userName", userName));

			if (validUser == null) {
				status = false;
			}
		} catch (Exception e) {
			status = false;
			// TODO: handle exception
		}
		return status;

	}

	public Boolean validateEmpId(String empId) {

		logger.info("validateEmpId");

		Boolean status = true;

		try {
			DBCollection userDetails = mongoTemplate.getCollection("user");

			DBObject validEmpId = userDetails.findOne(new BasicDBObject(
					"empId", empId));

			if (validEmpId == null) {
				status = false;
			}
		} catch (Exception e) {
			status = false;
			
		}
		return status;

	}
}
