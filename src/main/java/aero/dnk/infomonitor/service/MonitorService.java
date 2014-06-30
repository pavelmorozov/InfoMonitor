package aero.dnk.infomonitor.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

public interface MonitorService {
	public ModelAndView list();
	public ModelAndView show(String monitorName);
	public ModelAndView showAJAX(String monitorName);
}
