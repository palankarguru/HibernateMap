package com.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Addresspojo {
	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction trans = s.beginTransaction();

		StudentPojo sp1 = new StudentPojo(101, "Sun");
		StudentPojo sp2 = new StudentPojo(102, "Dam");
		StudentPojo sp3 = new StudentPojo(103, "Kam");
		Subject sub1 = new Subject("English");
		Subject sub2 = new Subject("Mathematics");
		Subject sub3 = new Subject("Science");
		Books book1 = new Books(111, "Java");
		Books book2 = new Books(222, "Hibernate");
		Books book3 = new Books(333, "Spring");

		
		s.save(sp1);
		s.save(sp2);
		s.save(sp3);
		s.save(sub1);
		s.save(sub2);
		s.save(sub3);
		s.save(book1);
		s.save(book2);
		s.save(book3);

		trans.commit();

		s.close();

	}

}
