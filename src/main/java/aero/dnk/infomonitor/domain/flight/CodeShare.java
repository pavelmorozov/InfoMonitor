package aero.dnk.infomonitor.domain.flight;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table
public class CodeShare extends Flight {

	@ManyToOne
	@JoinColumn(name = "regularFlight")
	RegularFlight regularFlight;
	
	public CodeShare() {
		super();
	}

	public CodeShare(RegularFlight regularFlight ,String flightNumber, Company flightCompany){
		super(flightNumber, flightCompany);
		this.regularFlight = regularFlight;
	}

	public RegularFlight getRegularFlight() {
		return regularFlight;
	}

	public void setRegularFlight(RegularFlight regularFlight) {
		this.regularFlight = regularFlight;
	}
	
}
