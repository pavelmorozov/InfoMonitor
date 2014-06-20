package aero.dnk.infomonitor.dao.monitor;

import java.util.List;

import org.springframework.dao.DataAccessException;

import aero.dnk.infomonitor.domain.monitor.FlightRegistrationInfo;

public interface FlightRegistrationInfoDAO {
	void save(FlightRegistrationInfo flightRegistrationInfo) throws DataAccessException;
	void remove(FlightRegistrationInfo flightRegistrationInfo) throws DataAccessException;
	FlightRegistrationInfo get(String id) throws DataAccessException;
	public List <FlightRegistrationInfo> list()
		throws DataAccessException;
}
