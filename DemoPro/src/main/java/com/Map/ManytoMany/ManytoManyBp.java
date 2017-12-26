package com.Map.ManytoMany;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManytoManyBp {

	
	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();

		BookMTM_PB b1 = new BookMTM_PB(11,"Java"); 
		BookMTM_PB b2 = new BookMTM_PB(12,"Hibernate");
		

		AuthorMTM_PB a1 = new AuthorMTM_PB(1,"Patel",10001);
		AuthorMTM_PB a2 = new AuthorMTM_PB(2,"Durga",11001);
		
		List<AuthorMTM_PB> li=new ArrayList<AuthorMTM_PB>();
		li.add(a1);
		li.add(a2);
		
		List<AuthorMTM_PB> li1=new ArrayList<AuthorMTM_PB>();
		li1.add(a2);
		
		b1.setauthor(li);
		b2.setauthor(li1);
		
		s.save(b1);
		s.save(b2);
		
		t.commit();
	s.close();
	}

}

@Entity
@Table(name="book_N")
class BookMTM_PB {

	@Id
	private int bId;
	@Column
	private String bName;

	@ManyToMany(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	List<AuthorMTM_PB> author;

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

	public List<AuthorMTM_PB> getauthor() {
		return author;
	}

	public void setauthor(List<AuthorMTM_PB> author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "BookMTM_PB [bId=" + bId + ", bName=" + bName + ", author=" + author + "]";
	}

	public BookMTM_PB(int bId, String bName) {
		super();
		this.bId = bId;
		this.bName = bName;
		//this.author = author;
	}

	public BookMTM_PB() {
		super();
		// TODO Auto-generated constructor stub
	}
		
}

@Entity
@Table(name="author_N")
class AuthorMTM_PB {

	@Id
	private int aId;
	@Column
	private String aName;
	@Column
	private int aPrice;
	
	@ManyToMany(mappedBy="author")
	List<BookMTM_PB> book;

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public int getaPrice() {
		return aPrice;
	}

	public void setaPrice(int aPrice) {
		this.aPrice = aPrice;
	}

	public List<BookMTM_PB> getbook() {
		return book;
	}

	public void setauthor(List<BookMTM_PB> book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "AuthorMTM_PB [aId=" + aId + ", aName=" + aName + ", aPrice=" + aPrice + ", book=" + book
				+ "]";
	}

	public AuthorMTM_PB(int aId, String aName, int aPrice) {
		super();
		this.aId = aId;
		this.aName = aName;
		this.aPrice = aPrice;
		//this.book = book;
	}

	public AuthorMTM_PB() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
}
