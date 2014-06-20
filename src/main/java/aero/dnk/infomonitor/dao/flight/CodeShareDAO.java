package aero.dnk.infomonitor.dao.flight;

import java.util.List;

import org.springframework.dao.DataAccessException;

import aero.dnk.infomonitor.domain.flight.CodeShare;
import aero.dnk.infomonitor.domain.flight.Company;
import aero.dnk.infomonitor.domain.flight.Destination;
import aero.dnk.infomonitor.domain.flight.RegularFlight;

public interface CodeShareDAO {
	void save(CodeShare codeShare) throws DataAccessException;
	void remove(CodeShare codeShare) throws DataAccessException;
	CodeShare get(Long id) throws DataAccessException;
	public List <CodeShare> list()
		throws DataAccessException;
	public List <CodeShare> search(String flightNumber, Company company)
		throws DataAccessException;	
}
