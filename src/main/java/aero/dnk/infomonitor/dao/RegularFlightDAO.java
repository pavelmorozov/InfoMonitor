package aero.dnk.infomonitor.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import aero.dnk.infomonitor.domain.Company;
import aero.dnk.infomonitor.domain.Destination;
import aero.dnk.infomonitor.domain.RegularFlight;

public interface RegularFlightDAO {
	void save(RegularFlight regularFlight) throws DataAccessException;
	void remove(RegularFlight regularFlight) throws DataAccessException;
	RegularFlight get(Long id) throws DataAccessException;
	public List <RegularFlight> list()
		throws DataAccessException;
	public List <RegularFlight> search(Destination destination,
			String flightNumber, Company company)
		throws DataAccessException;	
}
