package aero.dnk.infomonitor.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import aero.dnk.infomonitor.service.UserService;

/**
 * Handles user requests 
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Lists monitors.
	 */	
	@RequestMapping(value = "/user/listMonitors", method = RequestMethod.GET)
	public ModelAndView monitorList() {
		return userService.monitorList();
	}

	/**
	 * Get data to populate user form.
	 */
	@RequestMapping(value = "/user/fillFlightRegistrationInfoForm", method = RequestMethod.GET)
	public ModelAndView getFlights(HttpServletRequest request) {
		logger.info("Processing getFlights() request from: "+
				request.getRemoteAddr());
		return userService.fillFlightRegistrationInfoForm();		
	}
	
	/**
	 * Update monitor with user data send.
	 */	
	@RequestMapping(value = "/user/setFlightRegistrationInfo",  produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String setFlightRegistrationInfo (
			@RequestParam(value = "monitor") String monitor,
			@RequestParam(value = "flightNumber") String flightNumber,
			@RequestParam(value = "flightClass") String flightClass){
		String response = userService.setFlightRegistrationInfo(monitor,flightNumber,flightClass);
		return response;
	}
	
//	@RequestMapping(value = "/" + ADMINPAGE + "/fillUserAccount",  produces = "text/html; charset=UTF-8")
//	@ResponseBody
//	public String fillUserAccount (
//			@RequestParam(value = "account") String accountId,
//			@RequestParam(value = "amount") String amount
//			) throws Exception{
//		String balance = adminService.fillUserAccount( accountId, amount);
//		String response = "{\"text\":\"Пополнение на сумму: "
//				+amount+" выполнено успешно\",\"balance\":\""+
//				balance+"\"}";
//		return response;
//	}
	
	
	
}
