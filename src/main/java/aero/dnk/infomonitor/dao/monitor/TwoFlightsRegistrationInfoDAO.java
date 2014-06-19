package aero.dnk.infomonitor.dao.monitor;

import java.util.List;

import org.springframework.dao.DataAccessException;

import aero.dnk.infomonitor.domain.monitor.TwoFlightsRegistrationInfo;

public interface TwoFlightsRegistrationInfoDAO {
	void save(TwoFlightsRegistrationInfo twoFlightsRegistrationInfo) throws DataAccessException;
	void remove(TwoFlightsRegistrationInfo twoFlightsRegistrationInfo) throws DataAccessException;
	TwoFlightsRegistrationInfo get(String id) throws DataAccessException;
	public List <TwoFlightsRegistrationInfo> list()
		throws DataAccessException;
}
