package aero.dnk.infomonitor.domain.flight;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class DestinationMultiLanguage implements Comparable {
	@Id
	@GeneratedValue
	@Column(unique = true, nullable = false, insertable=false, updatable=false)
	private Long id;
	
	@Column
	private String airPortMultiLanguage;
	
	@ManyToOne()
	@JoinColumn(name = "destination")
	
	private Destination destination;

	public DestinationMultiLanguage() {
	}
	
	public DestinationMultiLanguage(String airPortMultiLanguage
			, Destination destination
			) {
		this.airPortMultiLanguage = airPortMultiLanguage;
		this.destination = destination;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAirPortMultiLanguage() {
		return airPortMultiLanguage;
	}

	public void setAirPortMultiLanguage(String airPortMultiLanguage) {
		this.airPortMultiLanguage = airPortMultiLanguage;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	@Override
	public int compareTo(Object o) {
	    //FoodItems temp = (FoodItems) o;
	    if (this.airPortMultiLanguage.compareTo(airPortMultiLanguage)>0)
	        return 1;
	    else if (this.airPortMultiLanguage.compareTo(airPortMultiLanguage)==0)
	        return 0;
	    else 
	        return -1;
	}
}
