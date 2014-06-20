package aero.dnk.infomonitor.domain.monitor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import aero.dnk.infomonitor.domain.flight.RegularFlight;

@Entity
@Table
public class TwoFlightsRegistrationInfo extends MonitorInfo {
	@ManyToOne()
	@JoinColumn(name = "flight1")
	private RegularFlight flight1;

	@ManyToOne()
	@JoinColumn(name = "flight2")
	private RegularFlight flight2;
	
	public TwoFlightsRegistrationInfo(){
	}

	public TwoFlightsRegistrationInfo(String id, RegularFlight flight1,
			RegularFlight flight2) {
		super(id);
		this.flight1 = flight1;
		this.flight2 = flight2;
	}

	public RegularFlight getFlight1() {
		return flight1;
	}

	public void setFlight1(RegularFlight flight1) {
		this.flight1 = flight1;
	}

	public RegularFlight getFlight2() {
		return flight2;
	}

	public void setFlight2(RegularFlight flight2) {
		this.flight2 = flight2;
	}
}
