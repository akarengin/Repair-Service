package com.enginakar.models;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class Laptop extends Computer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String touchPad;

	public Laptop() {
		super();
	}

	public String getTouchPad() {
		return touchPad;
	}

	public void setTouchPad(String touchPad) {
		this.touchPad = touchPad;
	}
	
	public void changedSpecPart(Product product) {
		if(((Laptop) product).getTouchPad() != "") {
			product.setPiece("touchPad");
		}
	}
}
