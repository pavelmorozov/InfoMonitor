package aero.dnk.infomonitor.service;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import aero.dnk.infomonitor.controller.HomeController;
import aero.dnk.infomonitor.dao.monitor.MonitorDAO;
import aero.dnk.infomonitor.domain.monitor.Monitor;
import aero.dnk.infomonitor.domain.monitor.MonitorInfo;

@Service
@Transactional
public class MonitorServiceImpl implements MonitorService {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);	
	
	@Autowired
	private MonitorDAO monitorDAO;	
	
	@Override
	public ModelAndView list(){
		List<Monitor> monitorList = monitorDAO.list();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("monitorList", monitorList);
		return new ModelAndView("monitorList", map);
	}
	
	@Override
	public ModelAndView show(String monitorName){
		Monitor monitor = monitorDAO.get(monitorName);
		MonitorInfo monitorInfo = monitor.getMonitorInfo();
		
		String viewName;
		Map<String, Object> viewInfo = new HashMap<String, Object>();
		if (monitorInfo!=null) {
			viewName = monitorInfo.getClass().getSimpleName();
			viewInfo.put("monitorInfo", monitorInfo);
			logger.info("Service MonitorService show() choose view name: "+
					viewName);		
		}
		else
		{
			viewName = "Error";
			logger.info("Error: "+ monitorName +" Monitor info not found");			
		}
		
		return new ModelAndView(viewName, viewInfo);
	}
}
