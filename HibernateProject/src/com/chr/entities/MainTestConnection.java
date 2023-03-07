package com.chr.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainTestConnection {
	public static void main(String args[]) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class).buildSessionFactory();
		Session session = factory.openSession();
		try {
			Customer cliente = new Customer("Ricardo","Bautista", "El  Salvador");
			session.beginTransaction();
			session.save(cliente);
			session.getTransaction().commit();
			System.out.println("success save");
			session.beginTransaction();
			System.out.println("id: "+cliente.getIdCustomer());
			Customer clienteInsertado = session.get(Customer.class, cliente.getIdCustomer());
			System.out.println("registro: " + clienteInsertado);
		}catch(Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		finally {
			session.close();

			factory.close();
		}
	}
}
