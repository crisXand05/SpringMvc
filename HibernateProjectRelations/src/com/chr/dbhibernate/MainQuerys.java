package com.chr.dbhibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chr.entities.Customer;

public class MainQuerys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class).buildSessionFactory();
		Session sesion = factory.openSession();
		try {
			/*List<Customer> clientes = selectCustomer(sesion);
			printCustomer(clientes);
			sesion.getTransaction().commit();*/
			deleteCustomer(sesion);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sesion.close();

			factory.close();
		}
	}
	
	public static void printCustomer(List<Customer> clientes) {
		for(Customer cliente:clientes) {
			System.out.println(cliente);
		}
	}
	
	public static List<Customer> selectCustomer(Session sesion) {
		sesion.beginTransaction();
		List<Customer> clientes = sesion.createQuery("from Customer").getResultList();
		printCustomer(clientes);
		clientes = sesion.createQuery("from Customer cust where cust.lastName = 'Bautista'").getResultList();
		return clientes;
	}
	
	public static void updateCustomer(Session sesion, int id) {
		sesion.beginTransaction();
		Customer clienteToUpdate = sesion.get(Customer.class, id );
		clienteToUpdate.setAddress("Ilopango San Salvador");
		sesion.getTransaction().commit();
		System.out.println("Registro actualizado");
		
	}
	public static void updateCustomerHql(Session sesion) {
		sesion.beginTransaction();
		
		sesion.createQuery("update Customer set lastName = 'Bautista' Where lastName like 'j%'").executeUpdate();
		
		sesion.getTransaction().commit();
		System.out.println("Registro actualizado");
		
	}
	
	public static void deleteCustomer(Session sesion) {
		sesion.beginTransaction();
		sesion.createQuery("delete Customer Where nameCustomer = 'perez'").executeUpdate();
		sesion.getTransaction().commit();
		System.out.println("Registro borrado");
	}
}
