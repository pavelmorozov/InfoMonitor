package aero.dnk.infomonitor.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import aero.dnk.infomonitor.dao.flight.RegularFlightDAO;
import aero.dnk.infomonitor.dao.monitor.FlightClassDAO;
import aero.dnk.infomonitor.dao.monitor.MonitorDAO;
import aero.dnk.infomonitor.dao.monitor.MonitorInfoDAO;
import aero.dnk.infomonitor.domain.flight.RegularFlight;
import aero.dnk.infomonitor.domain.monitor.FlightClass;
import aero.dnk.infomonitor.domain.monitor.FlightRegistrationInfo;
import aero.dnk.infomonitor.domain.monitor.Monitor;
import aero.dnk.infomonitor.domain.monitor.MonitorInfo;


@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private MonitorInfoDAO monitorInfoDAO;
	
	@Autowired
	private MonitorDAO monitorDAO;
	
	@Autowired
	private RegularFlightDAO regularFlightDAO;

	@Autowired
	private FlightClassDAO flightClassDAO;
	
	@Override
	public ModelAndView monitorList() {
		List<Monitor> monitorList = monitorDAO.list();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("monitorList", monitorList);
		return new ModelAndView("monitorList", map);
	}

	@Override
	public ModelAndView fillFlightRegistrationInfoForm() {
		String viewName = "flightRegistrationInfoForm";
		List<RegularFlight> regularFlightList = regularFlightDAO.list();
		List<FlightClass> classList = flightClassDAO.list();
		Map<String, Object> viewInfo = new HashMap<String, Object>();
		viewInfo.put("regularFlightList", regularFlightList);
		viewInfo.put("classList", classList);
		return new ModelAndView(viewName, viewInfo);		
	}

	@Override
	public String setFlightRegistrationInfo(
		String monitorId,
		String flightNumber, 
		String flightClass) {
		
			//delete MonitorInfo with id passed
			Monitor monitor = monitorDAO.get(monitorId);
			monitor.setMonitorInfo(null);
			
			MonitorInfo monitorInfo = monitorInfoDAO.get(monitorId);
			if (monitorInfo != null){
				monitorInfoDAO.remove(monitorInfo);
			}
		
			//save MonitorInfo
			monitorInfo = new 
				FlightRegistrationInfo(monitorId, 
					regularFlightDAO.get(Long.parseLong(flightNumber)), 
					flightClassDAO.get(Long.parseLong(flightClass)));
			monitor.setMonitorInfo(monitorInfo);
			monitorDAO.save(monitor);
	
			String response = "{\"flightNumber\":\""+((FlightRegistrationInfo)monitorInfo).getFlight().getFlightNumber()+"\","
					+ "\"flightClass\":\""+((FlightRegistrationInfo)monitorInfo).getFlightClass().getClassName()+"\","
					+ "\"destination\":\""+((FlightRegistrationInfo)monitorInfo).getFlight().getFlightDestination().getAirPort()+"\","
					+ "\"company\":\""+((FlightRegistrationInfo)monitorInfo).getFlight().getFlightCompany().getName()+"\","
					+ "\"monitor\":\""+monitorInfo.getId()+"\"}";
			return response;
	}	
}
