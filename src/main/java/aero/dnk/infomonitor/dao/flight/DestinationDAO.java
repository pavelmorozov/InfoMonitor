package aero.dnk.infomonitor.dao.flight;

import org.springframework.dao.DataAccessException;

import aero.dnk.infomonitor.domain.flight.Destination;

public interface DestinationDAO {
	Destination getDestination(Long id) throws DataAccessException;
	void saveDestination(Destination destination) throws DataAccessException;
	void removeDestination(Destination destination) throws DataAccessException;
}
