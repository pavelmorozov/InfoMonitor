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
	String monitorName;
	
	@OneToOne()
	MonitorInfo monitorInfo;

	public Monitor() {
	}
	
	public Monitor(String monitorName, MonitorInfo monitorInfo) {
		this.monitorName = monitorName;
		this.monitorInfo = monitorInfo;
	}

	public String getMonitorName() {
		return monitorName;
	}

	public void setMonitorName(String monitorName) {
		this.monitorName = monitorName;
	}

	public MonitorInfo getMonitorInfo() {
		return monitorInfo;
	}

	public void setMonitorInfo(MonitorInfo monitorInfo) {
		this.monitorInfo = monitorInfo;
	}
}
