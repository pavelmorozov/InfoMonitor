package aero.dnk.infomonitor.dao.monitor;

import java.util.List;

import org.springframework.dao.DataAccessException;

import aero.dnk.infomonitor.domain.monitor.Monitor;

public interface MonitorDAO {
	void save(Monitor monitor) throws DataAccessException;
	void remove(Monitor monitor) throws DataAccessException;
	Monitor get(String id) throws DataAccessException;
	public List <Monitor> list()
		throws DataAccessException;
}
