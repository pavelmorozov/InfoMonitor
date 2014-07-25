package aero.dnk.infomonitor.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import aero.dnk.infomonitor.service.MonitorService;

/**
 * Handles requests from monitors 
 */
@Controller
public class MonitorController{

	@Autowired
	private MonitorService monitorService;
	
	private static final Logger logger = LoggerFactory.getLogger(MonitorController.class);
	
	/**
	 * Takes from monitor its name and pass to service. Returns 
	 * html view for MonitorInfo 
	 */
	@RequestMapping(value = "/monitor/show", method = RequestMethod.GET)
	public ModelAndView monitorShow(@RequestParam("monitorName") String monitorName, HttpServletRequest request) {
		logger.info("Processing AJAX request from: "+
				request.getRemoteAddr()+
				" to monitor: "+ monitorName);
		return monitorService.show(monitorName);
	}	
	/**
	 * Takes from monitor its name and pass to service. Returns page with ajax auto refresh code
	 */
	@RequestMapping(value = "/monitor/showAJAX", method = RequestMethod.GET)
	public ModelAndView monitorShowAJAX(@RequestParam("monitorName") String monitorName, HttpServletRequest request) {
		logger.info("Processing request from: "+
				request.getRemoteAddr()+
				" to monitor: "+ monitorName);
		//return monitorService.show(monitorName);
		return monitorService.showAJAX(monitorName);		
	}
}
