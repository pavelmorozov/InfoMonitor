package aero.dnk.infomonitor.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import aero.dnk.infomonitor.dao.flight.RegularFlightDAO;
import aero.dnk.infomonitor.dao.media.ImageDAO;
import aero.dnk.infomonitor.dao.monitor.FlightClassDAO;
import aero.dnk.infomonitor.dao.monitor.ImageInfoDAO;
import aero.dnk.infomonitor.dao.monitor.MonitorDAO;
import aero.dnk.infomonitor.dao.monitor.MonitorInfoDAO;
import aero.dnk.infomonitor.domain.flight.RegularFlight;
import aero.dnk.infomonitor.domain.media.Image;
import aero.dnk.infomonitor.domain.monitor.FlightClass;
import aero.dnk.infomonitor.domain.monitor.FlightRegistrationInfo;
import aero.dnk.infomonitor.domain.monitor.ImageInfo;
import aero.dnk.infomonitor.domain.monitor.TwoFlightsRegistrationInfo;
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

	@Autowired
	private ImageDAO imageDAO;
		
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
		
		MonitorInfo monitorInfo = new 
				FlightRegistrationInfo(monitorId, 
					regularFlightDAO.get(Long.parseLong(flightNumber)), 
					flightClassDAO.get(Long.parseLong(flightClass)));
		
		monitorInfoDAO.update(monitorInfo);
			
		String response = 
				"{\"MonitorInfoString\":\""+ 
				((FlightRegistrationInfo)monitorInfo).getFlight().getFlightNumber()
				+" ("+((FlightRegistrationInfo)monitorInfo).getFlight().getFlightDestination().getAirPort()+") "
				+ ((FlightRegistrationInfo)monitorInfo).getFlight().getFlightCompany().getName()+" - "
				+((FlightRegistrationInfo)monitorInfo).getFlightClass().getClassName()+";\","
				+ "\"monitor\":\"" + monitorInfo.getId()+"\"}";
		return response;
	}

	@Override
	public ModelAndView fillTwoFlightsRegistrationInfoForm() {
		String viewName = "twoFlightsRegistrationInfoForm";
		List<RegularFlight> regularFlightList = regularFlightDAO.list();
		Map<String, Object> viewInfo = new HashMap<String, Object>();
		viewInfo.put("regularFlightList", regularFlightList);
		return new ModelAndView(viewName, viewInfo);
	}

	@Override
	public String setTwoFlightsRegistrationInfo(String monitor, String flight1,
			String flight2) {
		MonitorInfo monitorInfo = new 
			TwoFlightsRegistrationInfo(monitor, 
				regularFlightDAO.get(Long.parseLong(flight1)), 
				regularFlightDAO.get(Long.parseLong(flight2)));
		monitorInfoDAO.update(monitorInfo);
		String response = 
				"{\"MonitorInfoString\":\""+ ((TwoFlightsRegistrationInfo)monitorInfo).
					getFlight1().getFlightNumber()
					+" ("+((TwoFlightsRegistrationInfo)monitorInfo).getFlight1().
						getFlightDestination().getAirPort()+") "
					+ ((TwoFlightsRegistrationInfo)monitorInfo).
					getFlight1().getFlightCompany().getName()+"; "
					+((TwoFlightsRegistrationInfo)monitorInfo).
					getFlight2().getFlightNumber()
					+" ("+((TwoFlightsRegistrationInfo)monitorInfo).getFlight2().
						getFlightDestination().getAirPort()+") "
					+ ((TwoFlightsRegistrationInfo)monitorInfo).
					getFlight2().getFlightCompany().getName()+";\","
					+ "\"monitor\":\"" + monitorInfo.getId()+"\"}";					
		return response;
	}

	@Override
	public ModelAndView fillImageInfoForm() {
		String viewName = "imageInfoForm";
		List<Image> imageList = imageDAO.list();
		Map<String, Object> viewInfo = new HashMap<String, Object>();
		viewInfo.put("imageList", imageList);
		return new ModelAndView(viewName, viewInfo);
	}

	@Override
	public String setImageInfo(String monitor, String image) {
		MonitorInfo monitorInfo = new 
				ImageInfo(monitor, 
					imageDAO.get(Long.parseLong(image)));
			monitorInfoDAO.update(monitorInfo);
		String response = 
				"{\"MonitorInfoString\":\""+ ((ImageInfo)monitorInfo).
					getImage().getImageName()+";\","
					+ "\"monitor\":\"" + monitorInfo.getId()+"\"}";					
		return response;

	}	
}