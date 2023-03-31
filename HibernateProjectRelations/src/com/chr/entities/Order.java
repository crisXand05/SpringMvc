package com.chr.entities;


import java.util.GregorianCalendar;

import javax.persistence.*;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(name = "fecha")
	private GregorianCalendar dateField;
	
	@Column(name = "formapago")
	private String formaPago;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name="customer_id",referencedColumnName = "idCustomer")
	private Customer customer;
	
	public Order(GregorianCalendar date) {
		
		this.dateField = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customerId) {
		this.customer = customerId;
	}

	@Override
	public String toString() {
		return "Order [date=" + dateField + ", formaPago=" + formaPago + ", customerId=" + customer + "]";
	}
	
	
	
	
}
