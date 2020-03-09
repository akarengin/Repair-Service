package com.enginakar.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "Product_Type")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	@TableGenerator(name = "Product_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "product_gen")
	private int id;
	private String brand;
	private int serviceFee;
	protected String piece;

	@Basic
	@Temporal(TemporalType.DATE)
	protected Date date;

	@Basic
	@Temporal(TemporalType.DATE)
	protected Date repairDate;
	private int price;

	@ManyToOne(optional = false)
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;

	public Product() {

	}

	public Product(int id, String brand, int serviceFee, String piece, Date date, Date repairDate, int price,
			Customer customer) {
		this.id = id;
		this.brand = brand;
		this.serviceFee = serviceFee;
		this.piece = piece;
		this.date = date;
		this.repairDate = repairDate;
		this.price = price;
		this.customer = customer;
	}

	public int calculatePrice(int serviceFee, int pieceRate) {
		price = serviceFee + pieceRate;
		return price;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(int serviceFee) {
		this.serviceFee = serviceFee;
	}

	public String getPiece() {
		return piece;
	}

	public void setPiece(String piece) {
		this.piece = piece;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getRepairDate() {
		return repairDate;
	}

	public void setRepairDate(Date repairDate) {
		this.repairDate = repairDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product id=" + id + ", brand=" + brand + ", serviceFee=" + serviceFee + ", price=" + price
				+ ", customer=" + "(" + customer + ")";
	}
}
