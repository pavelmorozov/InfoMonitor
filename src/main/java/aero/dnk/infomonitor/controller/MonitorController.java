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
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Lists monitors.
	 */	
	@RequestMapping(value = "/monitor/list", method = RequestMethod.GET)
	public ModelAndView monitorList() {
		return monitorService.list();
	}

	/**
	 * Takes from monitor its name and pass to service.
	 */
	@RequestMapping(value = "/monitor/show", method = RequestMethod.GET)
	public ModelAndView monitorShow(@RequestParam("monitorName") String monitorName, HttpServletRequest request) {
		logger.info("Processing request from: "+
				request.getRemoteAddr()+
				" to monitor: "+ monitorName);
		return monitorService.show(monitorName);
	}	
}
