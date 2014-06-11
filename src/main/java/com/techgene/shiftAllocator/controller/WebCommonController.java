package com.techgene.shiftAllocator.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;




/**
 * 
 * Requests related to the redirecting pages related urls are
 * handled by WebCommonController
 * 
 * @author techgene
 * 
 */
@Controller
public class WebCommonController {

	private Logger logger = LoggerFactory.getLogger(WebCommonController.class);

	

	@Autowired
	private WebControllerUtils wcutils;





	@RequestMapping(value = "/error404", method = RequestMethod.GET)	
	public ModelAndView showError404Page(HttpServletRequest request, HttpServletResponse response,  ModelMap modelmap) {	
		logger.debug(">> showError404Page");

		/* if user not in the session then user is simply redirected to error page
		 * else if user is in session then user is logged out from the session and then 
		 * redirected to error page
		 */
		if(wcutils.getUsernameFromSession(request) != null){							
			if (request.getSession().getAttribute("user") != null) {
				request.getSession().removeAttribute("user");
			}
			request.getSession().invalidate();
			logger.info("users session is removed");
		}

		return new ModelAndView("genericerror");
	}


	@RequestMapping(value = "/error405", method = RequestMethod.GET)	
	public ModelAndView showError405Page(HttpServletRequest request, HttpServletResponse response,  ModelMap modelmap) {	
		logger.info(">> showError405Page");

		/* if user not in the session then user is simply redirected to error page
		 * else if user is in session then user is logged out from the session and then 
		 * redirected to error page
		 */
		if(wcutils.getUsernameFromSession(request) != null){							
			if (request.getSession().getAttribute("user") != null) {
				request.getSession().removeAttribute("user");
			}
			request.getSession().invalidate();
			logger.info("users session is removed");
		}

		return new ModelAndView("sessionexpireerror");
	}



	@RequestMapping(value = "/error500", method = RequestMethod.GET)	
	public ModelAndView showError500Page(HttpServletRequest request, HttpServletResponse response,  ModelMap modelmap) {	
		logger.debug(">> showError500Page");

		/* if user not in the session then user is simply redirected to error page
		 * else if user is in session then user is logged out from the session and then 
		 * redirected to error page
		 */
		if(wcutils.getUsernameFromSession(request) != null){							
			if (request.getSession().getAttribute("user") != null) {
				request.getSession().removeAttribute("user");
			}
			request.getSession().invalidate();
			logger.info("users session is removed");
		}

		return new ModelAndView("sessionexpireerror");
	}




}
