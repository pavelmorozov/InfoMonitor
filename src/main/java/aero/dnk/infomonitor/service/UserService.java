package aero.dnk.infomonitor.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

public interface UserService {
	ModelAndView monitorList();
	ModelAndView fillFlightRegistrationInfoForm();
	String setFlightRegistrationInfo(String monitor,String flightNumber,String flightClass);
	ModelAndView fillTwoFlightsRegistrationInfoForm();
	String setTwoFlightsRegistrationInfo(String monitor, String flight1, String flight2);
	ModelAndView fillImageInfoForm();
	String setImageInfo(String monitor,String image);
}
