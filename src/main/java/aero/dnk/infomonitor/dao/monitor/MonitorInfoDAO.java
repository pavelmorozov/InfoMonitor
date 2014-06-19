package aero.dnk.infomonitor.dao.monitor;

import java.util.List;

import org.springframework.dao.DataAccessException;

import aero.dnk.infomonitor.domain.monitor.MonitorInfo;

public interface MonitorInfoDAO {
	void save(MonitorInfo monitorInfo) throws DataAccessException;
	void remove(MonitorInfo monitorInfo) throws DataAccessException;
	MonitorInfo get(String id) throws DataAccessException;
	public List <MonitorInfo> list()
		throws DataAccessException;
}
