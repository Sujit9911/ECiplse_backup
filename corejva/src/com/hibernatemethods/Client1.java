package com.hibernatemethods;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Client1 {

	public static void main(String[] args) {
Configuration cfg=new Configuration();
cfg.configure();
cfg.addAnnotatedClass(employee1.class);
SessionFactory sf=cfg.buildSessionFactory();
Session session=sf.openSession();


session.close();
session.isOpen();
	}}
