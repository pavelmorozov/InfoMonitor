package aero.dnk.infomonitor.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

public interface UserService {
	public ModelAndView monitorList();
	public ModelAndView fillFlightRegistrationInfoForm();
	public String setFlightRegistrationInfo(String monitor,String flightNumber,String flightClass);
}
