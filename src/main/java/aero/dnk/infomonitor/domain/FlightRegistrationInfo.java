package aero.dnk.infomonitor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table
public class FlightRegistrationInfo implements MonitorInfo {
	//@Column
	private RegularFlight flight;
	
	//@Column
	private FlightClass flightClass;
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
	public FlightRegistrationInfo(RegularFlight flight, FlightClass flightClass) {
		super();
		this.flight = flight;
		this.flightClass = flightClass;
	}
}
