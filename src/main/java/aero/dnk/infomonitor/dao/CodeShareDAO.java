package aero.dnk.infomonitor.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import aero.dnk.infomonitor.domain.CodeShare;
import aero.dnk.infomonitor.domain.Company;
import aero.dnk.infomonitor.domain.Destination;
import aero.dnk.infomonitor.domain.RegularFlight;

public interface CodeShareDAO {
	void save(CodeShare codeShare) throws DataAccessException;
	void remove(CodeShare codeShare) throws DataAccessException;
	CodeShare get(Long id) throws DataAccessException;
	public List <CodeShare> list()
		throws DataAccessException;
	public List <CodeShare> search(String flightNumber, Company company)
		throws DataAccessException;	
}
