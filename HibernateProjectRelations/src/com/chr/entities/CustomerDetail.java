package com.chr.entities;

import javax.persistence.*;

@Entity
@Table(name="customer_details")
public class CustomerDetail {
	
	@Id
	@Column(name="id_details")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int idDetails;
	
	@Column(name="dui")
	private String dui;
	
	@Column(name="number_phone")
	private String numberPhone;

	
	
	public CustomerDetail(String dui, String numberPhone) {
		this.dui = dui;
		this.numberPhone = numberPhone;
	}

	public CustomerDetail() {
		
	}

	public int getIdDetails() {
		return idDetails;
	}

	public void setIdDetails(int idDetails) {
		this.idDetails = idDetails;
	}

	public String getDui() {
		return dui;
	}

	public void setDui(String dui) {
		this.dui = dui;
	}

	public String getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}
	
	
}
