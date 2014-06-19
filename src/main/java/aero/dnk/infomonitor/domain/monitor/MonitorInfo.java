package aero.dnk.infomonitor.domain.monitor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class MonitorInfo {
	@Id
	//the same as Monitor ID
	private String id;
	
	public MonitorInfo() {
	}
	
	public MonitorInfo(String id) {
		this.id = id;
	}	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}

