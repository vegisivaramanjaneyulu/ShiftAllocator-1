package com.techgene.shiftAllocator.model;

import org.springframework.data.annotation.Id;


public class User {
	@Id
	private String id;

	
	private String userName;
	private String password;
	private String userType;
	private String name;
	private String empId;
	private String email;
	private String reTypePassword;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getReTypePassword() {
		return reTypePassword;
	}

	public void setReTypePassword(String reTypePassword) {
		this.reTypePassword = reTypePassword;
	}
	

}
