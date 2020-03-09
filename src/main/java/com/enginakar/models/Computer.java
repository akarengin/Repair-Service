package com.enginakar.models;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public class Computer extends Product implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	protected String screen;
	
	protected String mouse;
	
	public void changedBasicPart(Product product) {
		if(((Computer) product).getScreen() != "") {
			product.setPiece("screen");
		}
		else if(((Computer) product).getMouse() != "") {
			product.setPiece("mouse");
		}
	}
		
	public int pieceChargeAndFixedDate() {
		Calendar calendarDate = Calendar.getInstance();
		date = calendarDate.getTime();
		int pieceCharge = 0; 
		switch (piece) {
		case ("mouse"):
			pieceCharge = 70;
			calendarDate.add(Calendar.MONTH, 8);
			break;
		case ("screen"):
			pieceCharge = 200;
			calendarDate.add(Calendar.YEAR, 1);
			break;
		case ("computerBox"):
			pieceCharge = 300;
			calendarDate.add(Calendar.YEAR, 2);
			break;
		case ("touchPad"):
			pieceCharge = 110;
			calendarDate.add(Calendar.MONTH, 10);
			break;
		}
		repairDate = calendarDate.getTime();
		return pieceCharge;
	}
	
	public String getMouse() {
		return mouse;
	}
	public void setMouse(String mouse) {
		this.mouse = mouse;
	}
	public String getScreen() {
		return screen;
	}
	public void setScreen(String screen) {
		this.screen = screen;
	}
	
	
}
