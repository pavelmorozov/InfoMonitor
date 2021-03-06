package aero.dnk.infomonitor.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import aero.dnk.infomonitor.dao.flight.RegularFlightDAO;
import aero.dnk.infomonitor.dao.monitor.FlightClassDAO;
import aero.dnk.infomonitor.dao.monitor.MonitorDAO;
import aero.dnk.infomonitor.domain.flight.RegularFlight;
import aero.dnk.infomonitor.domain.monitor.FlightClass;
import aero.dnk.infomonitor.domain.monitor.Monitor;
import aero.dnk.infomonitor.domain.monitor.MonitorInfo;

@Service
@Transactional
public class MonitorServiceImpl implements MonitorService {
	
	private static final Logger logger = LoggerFactory.getLogger(MonitorServiceImpl.class);	
	
	@Autowired
	private MonitorDAO monitorDAO;
	
	@Autowired
	private RegularFlightDAO regularFlightDAO;

	@Autowired
	private FlightClassDAO flightClassDAO;
	
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
		}else{
			viewName = "Error";
			logger.info("Error: "+ monitorName +" Monitor info not found");			
		}
		
		return new ModelAndView(viewName, viewInfo);
	}
	
	@Override
	public ModelAndView showAJAX(String monitorName){
		String viewName;
		viewName = "MonitorInfo";
		Map<String, Object> viewInfo = new HashMap<String, Object>();
		viewInfo.put("monitor", monitorName);
		System.out.println(viewInfo);
		System.out.println(monitorName);
		return new ModelAndView(viewName, viewInfo);
	}

	@Override
	public ModelAndView getFlights() {
		String viewName = "flightRegistrationInfoForm";
		List<RegularFlight> regularFlightList = regularFlightDAO.list();
		List<FlightClass> classList = flightClassDAO.list();
		Map<String, Object> viewInfo = new HashMap<String, Object>();
		viewInfo.put("regularFlightList", regularFlightList);
		viewInfo.put("classList", classList);
		return new ModelAndView(viewName, viewInfo);
	}	
}
