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
	
	@OneToOne(mappedBy="customerDetails", cascade = CascadeType.ALL)
	//@MapsId
	//@JoinColumn(name = "id_details")
	private Customer cliente;
	
	public Customer getCliente() {
		return cliente;
	}

	public void setCliente(Customer cliente) {
		this.cliente = cliente;
	}

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

	@Override
	public String toString() {
		return "CustomerDetail [idDetails=" + idDetails + ", dui=" + dui + ", numberPhone=" + numberPhone + ", cliente="
				+ cliente + "]";
	}
	
	
}
