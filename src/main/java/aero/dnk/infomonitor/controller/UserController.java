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
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	/**
	 * Lists monitors.
	 */	
	@RequestMapping(value = "/user/listMonitors", method = RequestMethod.GET)
	public ModelAndView monitorList() {
		return userService.monitorList();
	}

	/**
	 * Get data to populate user form fillFlightRegistrationInfoForm.
	 */
	@RequestMapping(value = "/user/FlightRegistrationInfo", method = RequestMethod.GET)
	public ModelAndView getFlights(HttpServletRequest request) {
		logger.info("Processing getFlights() request from: "+
				request.getRemoteAddr());
		return userService.fillFlightRegistrationInfoForm();		
	}
	
	/**
	 * Update monitor with user data send setFlightRegistrationInfo.
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
	
		
	/**
	 * Get data to populate user form fillTwoFlightsRegistrationInfoForm.
	 */
	@RequestMapping(value = "/user/TwoFlightsRegistrationInfo", method = RequestMethod.GET)
	public ModelAndView getTwoFlights(HttpServletRequest request) {
		logger.info("Processing getTwoFlights() request from: "+
				request.getRemoteAddr());
		return userService.fillTwoFlightsRegistrationInfoForm();		
	}

	/**
	 * Update monitor with user data send setTwoFlightsRegistrationInfo.
	 */	
	@RequestMapping(value = "/user/setTwoFlightsRegistrationInfo",  produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String setTwoFlightsRegistrationInfo (
			@RequestParam(value = "monitor") String monitor,
			@RequestParam(value = "flight1") String flight1,
			@RequestParam(value = "flight2") String flight2){
		String response = userService.setTwoFlightsRegistrationInfo(monitor,flight1,flight2);
		return response;
	}
		
	/**
	 * Get data to populate user form fillImageInfoForm.
	 */
	@RequestMapping(value = "/user/ImageInfo", method = RequestMethod.GET)
	public ModelAndView getImageInfo(HttpServletRequest request) {
		logger.info("Processing getImageInfo() request from: "+
				request.getRemoteAddr());
		return userService.fillImageInfoForm();		
	}

	/**
	 * Update monitor with user data send setTwoFlightsRegistrationInfo.
	 */	
	@RequestMapping(value = "/user/setImageInfo",  produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String setImageInfo(
			@RequestParam(value = "monitor") String monitor,
			@RequestParam(value = "image") String image){
		String response = userService.setImageInfo(monitor, image);
		return response;
	}
}
