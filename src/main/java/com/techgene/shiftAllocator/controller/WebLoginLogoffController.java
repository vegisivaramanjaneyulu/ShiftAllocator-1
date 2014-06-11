package com.techgene.shiftAllocator.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.techgene.shiftAllocator.model.User;
import com.techgene.shiftAllocator.service.EmployeeService;

/**
 * Login and logoff handlers
 * 
 * @author Sivaram
 * 
 */
@Controller
public class WebLoginLogoffController {

	private Logger logger = LoggerFactory
			.getLogger(WebLoginLogoffController.class);

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private WebControllerUtils wcutils;

	/**
	 * Shows the login page.
	 * 
	 * 
	 * 
	 * @param model
	 * 
	 * @param request
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView showLoginPage(ModelMap model, HttpServletRequest request) {

		logger.info(">> showLoginPage");

		ModelAndView returnView = null;

		model.addAttribute("user", new User());

		returnView = new ModelAndView("/");

		return returnView;

	}

	/**
	 * Login submit handler
	 * 
	 * @param user
	 * @param request
	 * @param flashData
	 * @param result
	 * @return
	 */

	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public ModelAndView submitLoginPage(@ModelAttribute("user") User user,
			HttpServletRequest request, RedirectAttributes flashData,
			BindingResult result) {

		logger.info("<< submitLoginPage");

		ModelAndView returnView = null;
		String statusMsg = null;
		int statusCode = 0;

		try {

			/*
			 * calling validate User method for User is valid or not. if the
			 * user is not valid then user = null else user object will hold the
			 * user details
			 */

			if (user.getUserType().equals("ProjectManager")
					|| user.getUserType().equals("TeamLeader")) {

				Boolean status = employeeService.validateCredentials(
						user.getUserName(), user.getPassword(),
						user.getUserType());
				if (status) {
					request.getSession().setAttribute("userName", user.getUserName());
					request.getSession().setAttribute("userType", user.getUserType());

					request.getSession().setAttribute("user", user);

					returnView = new ModelAndView("create-user", "user", user);

				} else {

					returnView = new ModelAndView("/login");
					request.getSession().setAttribute("invalid",
							"invalid userdetails");
				}
			}

			else if (user.getUserType().equals("Employee")) {

				Boolean status = employeeService.validateCredentials(
						user.getUserName(), user.getPassword(),
						user.getUserType());

				if (status) {
					
					request.getSession().setAttribute("userName", user.getUserName());
					request.getSession().setAttribute("userType", user.getUserType());

					request.getSession().setAttribute("user", user);

					returnView = new ModelAndView("planned-shifts-emp", "user",
							user);

				} else {
					request.getSession().setAttribute("invalid",
							"invalid userdetails");
					returnView = new ModelAndView("/login");

				}

			} else {
				request.getSession().setAttribute("invalid",
						"invalid userdetails");
				returnView = new ModelAndView("/login");
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			
		}

		logger.info(">> submitLoginPage [returnView = {}] ", returnView);
		return returnView;
	}

	/**
	 * Upon logoff action, this handler is called.
	 * 
	 * @param user
	 * @param model
	 * @param request
	 * @param session
	 * @param falshData
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/user/logOff")
	public ModelAndView logOff(HttpServletRequest request,
			RedirectAttributes falshData, ModelMap model) {

		logger.info(">> logOff ");

		/*
		 * if user is found in the session then user object is removed from
		 * session scope and then session is invalidated
		 */
		if (request.getSession().getAttribute("user") != null) {
			request.getSession().removeAttribute("user");
		}
		request.getSession().invalidate();

		// falshData.addFlashAttribute("statusMsg","You have logged out successfully.");
		// falshData.addFlashAttribute("statusCode", 0);
		model.addAttribute("logoutMsg", "You have logged out successfully.");
		logger.info("<< logOff ");

		return new ModelAndView("/login");
	}

}
