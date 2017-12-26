package com.Map.OnetoOne;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class OnetoOneBp {

	public static void main(String[] args) {

		Book bb1 = new Book(11, " Grammer", null);
		Book bb2 = new Book(12, " Tense", null);
		Book bb3 = new Book(13, " Verbs", null);

		Sub s1 = new Sub(1, "English", null);
		Sub s2 = new Sub(2, "Marati", null);
		Sub s3 = new Sub(3, "Maths", null);
		
		bb1.setbId(s1.getsId());
		s1.setBook(bb1);
		
		bb2.setbId(s2.getsId());
		s2.setBook(bb2);
		
		bb3.setbId(s3.getsId());
		s3.setBook(bb3);
		
		
		
		
		@SuppressWarnings("deprecation")
		SessionFactory se=new Configuration().configure().buildSessionFactory();
		Session session=se.openSession();

		Transaction t=session.beginTransaction();

		session.save(s1);
		session.save(s2);
		session.save(s3);
		
		t.commit();
		session.close();

	}

}

@Entity
@Table(name = "Sub_List")
class Sub {
	@Id

	private int sId;
	@Column
	private String sName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Book book;

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Sub [sId=" + sId + ", sName=" + sName + ", book=" + book + "]";
	}

	public Sub(int sId, String sName, Book book) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.book = book;
	}

	public Sub() {
		super();
		// TODO Auto-generated constructor stub
	}

}

@Entity
@Table(name = "Book_List")
class Book {
	@Id

	private int bId;
	@Column
	private String bName;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Sub sub;

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public Sub getSub() {
		return sub;
	}

	public void setSub(Sub sub) {
		this.sub = sub;
	}

	@Override
	public String toString() {
		return "Book [bId=" + bId + ", bName=" + bName + ", sub=" + sub + "]";
	}

	public Book(int bId, String bName, Sub sub) {
		super();
		this.bId = bId;
		this.bName = bName;
		this.sub = sub;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

}