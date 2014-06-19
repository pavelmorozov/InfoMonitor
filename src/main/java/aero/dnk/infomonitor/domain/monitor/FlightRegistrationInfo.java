package aero.dnk.infomonitor.domain.monitor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import aero.dnk.infomonitor.domain.flight.RegularFlight;

@Entity
@Table
public class FlightRegistrationInfo extends MonitorInfo {
	
	@Column
	private RegularFlight flight;
	
	@Column
	private FlightClass flightClass;
	
	public FlightRegistrationInfo() {
	}
	
	public FlightRegistrationInfo(String id, RegularFlight flight, FlightClass flightClass) {
		super(id);
		this.flight = flight;
		this.flightClass = flightClass;
	}
	public RegularFlight getFlight() {
		return flight;
	}
	public void setFlight(RegularFlight flight) {
		this.flight = flight;
	}
	public FlightClass getFlightClass() {
		return flightClass;
	}
	public void setFlightClass(FlightClass flightClass) {
		this.flightClass = flightClass;
	}

}
