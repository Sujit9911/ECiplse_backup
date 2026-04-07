package com.hibernatesetup;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class Client {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(hibertest.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		
		
		session.close();

	}

}
