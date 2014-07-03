package aero.dnk.infomonitor.domain.flight;

import java.util.HashSet;
//import java.util.List;


import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

//import org.hibernate.annotations.OrderBy;

@Entity
@Table
public class Destination {
	@Id
	@GeneratedValue
	@Column(unique = true, nullable = false, insertable=false, updatable=false)
	private Long id;
	
	@Column
	private String airPort;

	@OneToMany(cascade=CascadeType.ALL, mappedBy = "destination", fetch = FetchType.EAGER)
	@OrderBy("airPortMultiLanguage")

	//private SortedSet<DestinationMultiLanguage> destinationMultiLanguage = 
	//new TreeSet<DestinationMultiLanguage>();

	private Set<DestinationMultiLanguage> destinationMultiLanguage = 
	new HashSet<DestinationMultiLanguage>();
	
	
	public Destination(String airPort
			,  SortedSet<DestinationMultiLanguage> destinationMultiLanguage
			) {
		this.airPort = airPort;
		this.destinationMultiLanguage = destinationMultiLanguage;		
	}
	
	public Destination() {
	}
	
	public Set<DestinationMultiLanguage> getDestinationMultiLanguage() {
		return destinationMultiLanguage;
	}

	public void setDestinationMultiLanguage(
			Set<DestinationMultiLanguage> destinationMultiLanguage) {
		this.destinationMultiLanguage = destinationMultiLanguage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAirPort() {
		return airPort;
	}

	public void setAirPort(String airPort) {
		this.airPort = airPort;
	}	
	
	
}
