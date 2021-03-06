﻿package aero.dnk.infomonitor.domain.flight;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table
public class RegularFlight extends Flight {
	
	@ManyToOne()
	@JoinColumn(name = "flightDestination")
	private Destination flightDestination;
	
	@OneToMany(fetch = FetchType.EAGER)
	@OrderBy("flightCompany")
	private Set<CodeShare> codeShare = 
	    	new HashSet<CodeShare>();

	public Set<CodeShare> getCodeShare() {
		return codeShare;
	}

	public void setCodeShare(Set<CodeShare> codeShare) {
		this.codeShare = codeShare;
	}

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
