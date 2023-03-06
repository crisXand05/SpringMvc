package com.chr.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainTestConnection {
	public static void main(String args[]) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class).buildSessionFactory();
		Session session = factory.openSession();
		try {
			Customer cliente = new Customer("chr","mendoza", "san salvador");
			session.beginTransaction();
			session.save(cliente);
			session.getTransaction().commit();
			System.out.println("success save");
			session.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
	}
}
