package aero.dnk.infomonitor.domain.media;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Image {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String imageName;
	
	@Column
	private String imageFile;
	
	public Image() {
	}	

	public Image(String imageName, String imageFile) {
		this.imageName = imageName;
		this.imageFile = imageFile;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}
}
