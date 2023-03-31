package com.chr.dbhibernate;

import java.util.Date;
import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chr.entities.Customer;
import com.chr.entities.CustomerDetail;
import com.chr.entities.Order;

public class MainRelation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Customer.class)
				.addAnnotatedClass(CustomerDetail.class)
				.addAnnotatedClass(Order.class)
				.buildSessionFactory();
		Session sesion = factory.openSession();
		try {
			
			//addOrder(sesion,1);
			insertCustomer(sesion);
			System.out.println("commit");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sesion.close();
			factory.close();
			System.out.println("close");
		}
	}
	
	public static void insertCustomer(Session sesion) {
		Customer cliente = new Customer("Ma", "asdad","San adas");
		CustomerDetail detalles = new CustomerDetail("123456789", "12345678");
		cliente.setCustomerDetails(detalles);
		
		sesion.beginTransaction();
		sesion.save(cliente);
		sesion.getTransaction().commit();
	}
	
	public static void deleteCustomer(Session sesion, int id) {
		Customer clienteToDelete = sesion.get(Customer.class,id);
		sesion.beginTransaction();
		if(clienteToDelete != null) {
			sesion.delete(clienteToDelete);
			System.out.println("Registro id: "+ id + " Eliminado");
		}else {
			System.out.println("Registro no encontrado");
		}
		sesion.getTransaction().commit();
	}
	
	public static void getCustomer(Session sesion, int id) {
		sesion.beginTransaction();
		CustomerDetail detalle = sesion.get(CustomerDetail.class, id);
		System.out.println(detalle);
		System.out.println(detalle.getCliente());
		sesion.getTransaction().commit();
	}
	public static void addOrder(Session sesion, int idUser) {
		sesion.beginTransaction();
		Customer customer = sesion.get(Customer.class,idUser);
		Order order = new Order(new GregorianCalendar(2023,7,5));
		order.setFormaPago("efectivo");
		customer.agregarPedidos(order);
		sesion.save(order);
		sesion.getTransaction().commit();
		
	}
}
