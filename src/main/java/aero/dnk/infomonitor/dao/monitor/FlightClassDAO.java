﻿package aero.dnk.infomonitor.dao.monitor;

import java.util.List;

import org.springframework.dao.DataAccessException;

import aero.dnk.infomonitor.domain.monitor.FlightClass;

public interface FlightClassDAO {
	void save(FlightClass flightClass) throws DataAccessException;
	void remove(FlightClass flightClass) throws DataAccessException;
	FlightClass get(Long id) throws DataAccessException;
	public List <FlightClass> list()
		throws DataAccessException;
}
