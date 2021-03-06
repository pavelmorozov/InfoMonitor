﻿package aero.dnk.infomonitor.domain.monitor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class FlightClass {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String className;
	
	@Column
	private String classColor;	

	public FlightClass() {
	}	
	
	public FlightClass(String className, String classColor) {
		this.className = className;
		this.classColor = classColor;
	}
	
	public String getClassColor() {
		return classColor;
	}

	public void setClassColor(String classColor) {
		this.classColor = classColor;
	}	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
}
