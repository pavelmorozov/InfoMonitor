package aero.dnk.infomonitor.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table

public class RegularFlight extends Flight {
	
	@ManyToOne()
	@JoinColumn(name = "flightDestination")
	private Destination flightDestination;
	
	
	
	
	@OneToMany()
	private Set<CodeShare> codeShare = 
	    	new HashSet<CodeShare>();
	
	
	
	
	public RegularFlight(){};

	public RegularFlight(Destination flightDestination,	String flightNumber, 
			Company flightCompany) {
		this.flightDestination = flightDestination;
		super.setFlightNumber(flightNumber);
		super.setFlightCompany(flightCompany);		
	}

	public Destination getFlightDestination() {
		return flightDestination;
	}

	public void setFlightDestination(Destination flightDestination) {
		this.flightDestination = flightDestination;
	}
}
