package com.techgene.shiftAllocator.controller;

import java.io.IOException;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.techgene.shiftAllocator.DAO.ShiftCaluculaterDAO;
import com.techgene.shiftAllocator.dto.userShiftData;
import com.techgene.shiftAllocator.model.Employee;
import com.techgene.shiftAllocator.model.ShiftDetails;
import com.techgene.shiftAllocator.model.User;
import com.techgene.shiftAllocator.service.EmployeeService;
import com.techgene.shiftAllocator.service.ShiftCaluculaterService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ShiftsCaluculaterController {
	@Autowired
	private ShiftCaluculaterService shiftCShiftCaluculaterService;
	@Autowired
	private EmployeeService employeeService;

	private static final Logger logger = LoggerFactory
			.getLogger(ShiftsCaluculaterController.class);

	/**
	 * Upon planShifts action, this handler is called.
	 * 
	 * @param model
	 * @param shiftDetails
	 * @ResponseBody userShiftData[]
	 */

	@RequestMapping(value = "/plan-shifts", method = RequestMethod.POST)
	public ModelAndView planShifts(
			@ModelAttribute("command") ShiftDetails shiftDetails,
			ModelMap model, HttpServletRequest request)
			throws UnknownHostException {

		logger.info(">> planShifts ");

		request = shiftCShiftCaluculaterService.planShifts(shiftDetails,
				request);

		String[] date = shiftDetails.getDateStr().split("-");
		Boolean flag1 = (Boolean) request.getAttribute("flag1");
		Boolean flag2 = (Boolean) request.getAttribute("flag2");
		int empCount = (Integer) request.getAttribute("empCount");

		if (flag1) {
			model.addAttribute("shiftPlanStatus",
					"Shifts Planned for specified Month and Year Successfully!");
			model.addAttribute("status", "yes");
		}
		if (!flag1) {
			model.addAttribute("shiftPlanStatus",
					"You have Eneterd Invalied Details of Employee count per shift!");
			model.addAttribute("status", "no");
		}
		if (flag2 == false && flag1 == true) {
			model.addAttribute("shiftPlanStatus",
					"Shifts for Enterd month are all ready Planned!");
			model.addAttribute("status", "yes");
		}

		request.getSession().setAttribute("userName",
				request.getSession().getAttribute("userName"));
		request.getSession().setAttribute("userType",
				request.getSession().getAttribute("userType"));
		request.getSession().setAttribute("month", date[1]);
		request.getSession().setAttribute("empCount", empCount);

		return new ModelAndView("plan-shift-response");

	}

	/**
	 * Upon ShiftsDataOfMonth action, this handler is called.
	 * 
	 * @param model
	 * @ResponseBody userShiftData[]
	 */

	
	@RequestMapping(value="/getMonthResults", method = RequestMethod.POST)
	public @ResponseBody String getShiftsDataOfMonth(Model model,@RequestParam("month")String month,@RequestParam("userName")String userName,@RequestParam("userType")String userType,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException{
		
		logger.info(">> ShiftsDataOfMonth ");
		
		request.getSession().setAttribute("userName",request.getSession().getAttribute("userName"));
		request.getSession().setAttribute("userType",request.getSession().getAttribute("userType"));
		userShiftData response=shiftCShiftCaluculaterService.getShiftsDataOfMonth(month,userName,userType);
		
		Gson gson = new Gson();
		
		return gson.toJson(response);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/**
	 * Upon PlannedShiftPage action, this handler is called.
	 * 
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/get-plan-shifts-page", method = RequestMethod.GET)
	public ModelAndView getplanShiftPage(Model model) {

		logger.info(">> planShiftPage ");
		model.addAttribute("shiftPlanStatus",
				"Enter Following Details To Plan Shifts!!");

		model.addAttribute("command", new ShiftDetails());
		return new ModelAndView("plan-shift");
	}

	/**
	 * Upon PlannedShiftPage action, this handler is called.
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/get-planned-shifts-page")
	public String getPlannedShiftPage(HttpServletRequest request) {

		logger.info(">> PlannedShiftPage ");
		request.getSession().setAttribute("userName",
				request.getSession().getAttribute("userName"));
		request.getSession().setAttribute("userType",
				request.getSession().getAttribute("userType"));
		return "planned-shifts";
	}

	/**
	 * Upon PlannedShiftEmpPage action, this handler is called.
	 * 
	 * @param request
	 * @return
	 */

	@RequestMapping(value = "/get-planned-shifts-emppage")
	public String getPlannedShiftEmpPage(HttpServletRequest request) {

		logger.info(">> PlannedShiftEmpPage ");
		request.getSession().setAttribute("userName",
				request.getSession().getAttribute("userName"));
		request.getSession().setAttribute("userType",
				request.getSession().getAttribute("userType"));

		return "planned-shifts-emp";
	}

	/**
	 * Upon addUser action, this handler is called.
	 * 
	 * @param user
	 * @param request
	 * @return
	 */

	@RequestMapping(value = "/get-create-user-page")
	public String getCreateUserPage() {
		logger.info(">> addUser ");
		return "create-user";
	}

	/**
	 * Upon addUser action, this handler is called.
	 * 
	 * @param user
	 * @param request
	 * @return
	 */

	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute User user,
			HttpServletRequest request, ModelMap model) {

		logger.info(">> addUser ");

		Boolean status = employeeService.validateUser(user.getUserName());
		Boolean empStatus = employeeService.validateEmpId(user.getEmpId());

		ModelAndView returnView = null;

		if (!status && !empStatus) {

			User reg_user = employeeService.registerUser(user);
			request.getSession().setAttribute("user", reg_user);
			model.addAttribute("usersuccessmsg", "User Created Successfully!");
			logger.info(">> User created ");

			returnView = new ModelAndView("create-user", "user", user);

		} else {

			if (status) {
				logger.info(">> User Already Exists ");
				returnView = new ModelAndView("/create-user");

				model.addAttribute("userexistsmsg", "User Already Exists.");
			}

			if (empStatus) {

				returnView = new ModelAndView("/create-user");

				logger.info(">> Employee ID Already Exists. ");
				model.addAttribute("empidexistsmsg",
						"Employee ID Already Exists.");

			}

		}

		return returnView;
	}

	/**
	 * Upon createuser action, this handler is called.
	 * 
	 * @param user
	 * @param request
	 * @return
	 */

	@RequestMapping(value = "/user/createUser", method = RequestMethod.GET)
	public ModelAndView createuser(@ModelAttribute User user,
			HttpServletRequest request) {
		logger.info(">> createuser ");

		return new ModelAndView("create-user", "user", new User());
	}

}
