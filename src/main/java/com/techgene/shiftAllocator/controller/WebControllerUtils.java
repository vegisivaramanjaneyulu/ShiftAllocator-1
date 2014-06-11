package com.techgene.shiftAllocator.controller;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.techgene.shiftAllocator.model.User;



@Component
public class WebControllerUtils {

	private Logger logger = LoggerFactory.getLogger(WebControllerUtils.class);


	/**
	 * Get the username from the session
	 * 
	 * @param request
	 * 
	 * @return  the name of the user in session
	 */
	public String getUsernameFromSession(HttpServletRequest request){
		String username = null;
		
		if(request.getSession().getAttribute("user")!=null ){
			username = ((User)request.getSession().getAttribute("user")).getUserName();	
			
		}
		
		logger.info("<< getUsernameFromSession username = {}", username);

		return username;
	}
	
	public String getUserTypeFromSession(HttpServletRequest request){
		
		String userType= null;
		if(request.getSession().getAttribute("user")!=null ){
			
			userType=((User)request.getSession().getAttribute("user")).getUserType();	
		}
		
		logger.info("<< getUsernameFromSession username = {}", userType);

		return userType;
	}
	
	



	
}
