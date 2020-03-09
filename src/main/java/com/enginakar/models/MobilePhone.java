package com.enginakar.models;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class MobilePhone extends Phone implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String battery;
	private String touchScreen;

	public MobilePhone() {
		super();
	}

	public String getBattery() {
		return battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}

	public String getTouchScreen() {
		return touchScreen;
	}

	public void setTouchScreen(String touchScreen) {
		this.touchScreen = touchScreen;
	}
	
	public void changedSpecPart(Product product) {
		if (((MobilePhone) product).getBattery() != "") {
			product.setPiece("battery");
		} 
		if (((MobilePhone) product).getTouchScreen() != "") {
			product.setPiece("touchScreen");
		}
	}
}
