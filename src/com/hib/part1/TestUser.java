package com.hib.part1;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.Session;

public class TestUser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		AnnotationConfiguration config = new AnnotationConfiguration();
		
		config.addAnnotatedClass(User.class);
		config.configure();
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		User first = new User();
		first.setUser_id(1);
		first.setUser_name("Madhu");
		
		session.save(first);
		session.getTransaction().commit();
	}

}
