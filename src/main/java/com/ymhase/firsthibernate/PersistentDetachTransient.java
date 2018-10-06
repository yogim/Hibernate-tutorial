package com.ymhase.firsthibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ymhase.firsthibernate.model.UserOne;

public class PersistentDetachTransient {

	public static void main(String[] args) {

		UserOne userOne = new UserOne();
		userOne.setName("first object");// Transient object

		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();

		session.save(userOne);// Persistent object

		userOne.setName("first object update");

		session.getTransaction().commit();

		session.close();// detached object

	}

}
