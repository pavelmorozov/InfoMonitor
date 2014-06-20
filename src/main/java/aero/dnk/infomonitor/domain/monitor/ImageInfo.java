package aero.dnk.infomonitor.domain.monitor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import aero.dnk.infomonitor.domain.flight.RegularFlight;

@Entity
@Table
public class ImageInfo extends MonitorInfo {
	@Column
	private String imageName;
	
	@Column
	private String imagePath;

	public ImageInfo(){}
	
	public ImageInfo(String id, String imageName, String imagePath) {
		super(id);
		this.imageName = imageName;
		this.imagePath = imagePath;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
}
