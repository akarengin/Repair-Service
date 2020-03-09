package com.enginakar.models;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Phone extends Product implements Serializable {

	private static final long serialVersionUID = 1L;

	private String adaptor;

	public void changedBasicPart(Product product) {
		if (((Phone) product).getAdaptor() != "") {
			product.setPiece("adaptor");
		}
	}
	
	public int pieceChargeAndFixedDate() {
		Calendar calendarDate = Calendar.getInstance();
		date = calendarDate.getTime();
		int pieceCharge = 0;
		switch (piece) {
		case ("adaptor"):
			pieceCharge = 60;
			calendarDate.add(Calendar.MONTH, 10);
			break;
		case ("battery"):
			pieceCharge = 100;
			calendarDate.add(Calendar.YEAR, 1);
			break;
		case ("touchScreen"):
			pieceCharge = 140;
			calendarDate.add(Calendar.YEAR, 2);
			break;
		case ("receiver"):
			pieceCharge = 90;
			calendarDate.add(Calendar.YEAR, 5);
			break;
		}
		repairDate = calendarDate.getTime();
		return pieceCharge;
	}
	
	public String getAdaptor() {
		return adaptor;
	}

	public void setAdaptor(String adaptor) {
		this.adaptor = adaptor;
	}
}
