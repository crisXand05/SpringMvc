package com.chr.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@Column(name="idCustomer")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int idCustomer;
	
	@Column(name="nameCustomer")
	private String nameCustomer;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="address")
	private String address;
	
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private CustomerDetail customerDetails;
	
	@OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	private List<Order> orders;
	
	
	public CustomerDetail getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(CustomerDetail customerDetails) {
		this.customerDetails = customerDetails;
	}

	public Customer() {
		
	}
	
	public void agregarPedidos(Order order) {
		if(orders == null) orders = new ArrayList<>();	
		orders.add(order);
		order.setCustomer(this);
	}

	public Customer(String nameCustomer, String lastName, String address) {
		
		this.nameCustomer = nameCustomer;
		this.lastName = lastName;
		this.address = address;
	}
 
	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getNameCustomer() {
		return nameCustomer;
	}

	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [idCustomer=" + idCustomer + ", nameCustomer=" + nameCustomer + ", lastName=" + lastName
				+ ", address=" + address + "]";
	}
	
	
}
