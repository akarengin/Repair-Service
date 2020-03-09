package com.enginakar.models;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class LandLinePhone extends Phone implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String receiver;

	public LandLinePhone() {
		super();
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	
	public void changedSpecPart(Product product) {
		if (((LandLinePhone) product).getReceiver() != "") {
			product.setPiece("receiver");
		}
	}
}
