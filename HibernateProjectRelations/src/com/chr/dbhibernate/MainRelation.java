package com.chr.dbhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chr.entities.Customer;
import com.chr.entities.CustomerDetail;

public class MainRelation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Customer.class)
				.addAnnotatedClass(CustomerDetail.class)
				.buildSessionFactory();
		Session sesion = factory.openSession();
		try {
			deleteCustomer(sesion,3);
			//insertCustomer(sesion);
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
		Customer cliente = new Customer("Lisandro", "asdad","San adas");
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
}
