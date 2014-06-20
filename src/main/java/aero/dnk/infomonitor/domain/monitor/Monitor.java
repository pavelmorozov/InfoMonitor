package aero.dnk.infomonitor.domain.monitor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Monitor {
	@Id
	String MonitorName;
	
	@OneToOne()
	//@ForeignKey(name="email")
	MonitorInfo monitorInfo;

	public Monitor() {
	}
	
	public Monitor(String monitorName, MonitorInfo monitorInfo) {
		MonitorName = monitorName;
		this.monitorInfo = monitorInfo;
	}

	public String getMonitorName() {
		return MonitorName;
	}

	public void setMonitorName(String monitorName) {
		MonitorName = monitorName;
	}

	public MonitorInfo getMonitorInfo() {
		return monitorInfo;
	}

	public void setMonitorInfo(MonitorInfo monitorInfo) {
		this.monitorInfo = monitorInfo;
	}
}
