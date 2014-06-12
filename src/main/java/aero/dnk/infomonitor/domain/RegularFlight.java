package aero.dnk.infomonitor.domain;

import javax.persistence.Column;

public class RegularFlight extends Flight {
	
//	@Id
//	@Column(unique = true, nullable = false, insertable=false, updatable=false)
//	@GeneratedValue
//	private Long id;	
	
	@Column
	private Destination flightDestination;
	
	public RegularFlight(){};

	public RegularFlight(Destination flightDestination,	String flightNumber, 
			Company flightCompany) {
		this.flightDestination = flightDestination;
		super.setFlightNumber(flightNumber);
		super.setFlightCompany(flightCompany);		
	}

//	public Long getId() {
//		return id;
//	}

//	public void setId(Long id) {
//		this.id = id;
//	}

	public Destination getFlightDestination() {
		return flightDestination;
	}

	public void setFlightDestination(Destination flightDestination) {
		this.flightDestination = flightDestination;
	}
}
