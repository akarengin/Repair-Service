package com.enginakar.models;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class Pc extends Computer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String computerBox;

	public String getComputerBox() {
		return computerBox;
	}
	
	public Pc() {
		super();
	}
	
	public void setComputerBox(String computerBox) {
		this.computerBox = computerBox;
	}
	
	public void changedSpecPart(Product product) {
		if(((Pc) product).getComputerBox() != "") {
			product.setPiece("computerBox");
		}
	}
}
