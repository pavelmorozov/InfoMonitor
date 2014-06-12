package aero.dnk.infomonitor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.InheritanceType;

@Entity
@Table
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Flight {

	@Id
	@Column(unique = true, nullable = false, insertable=false, updatable=false)
	@GeneratedValue
	private Long id;
	@Column(unique = true, nullable = false, insertable=false, updatable=false)
	private String flightNumber;
	@Column
	private Company flightCompany;

	public Flight() {}	
	
	public Flight(String flightNumber, Company flightCompany) {
		this.flightNumber = flightNumber;
		this.flightCompany = flightCompany;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public Company getFlightCompany() {
		return flightCompany;
	}
	public void setFlightCompany(Company flightCompany) {
		this.flightCompany = flightCompany;
	}
}
