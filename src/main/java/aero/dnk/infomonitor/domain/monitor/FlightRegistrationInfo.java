package aero.dnk.infomonitor.domain.monitor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import aero.dnk.infomonitor.domain.flight.RegularFlight;

@Entity
@Table
public class FlightRegistrationInfo extends MonitorInfo {
	
	@ManyToOne()
	@JoinColumn(name = "flight")
	private RegularFlight flight;
	
	@OneToOne()
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
