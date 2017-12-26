package com.Map.ManytoMany;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManytoManyBjc {

	public static void main(String[] args) {
	
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();

		BookMTM_JCB b1 = new BookMTM_JCB(11,"Java"); 
		BookMTM_JCB b2 = new BookMTM_JCB(12,"Hibernate");
		

		AuthorMTM_JCB a1 = new AuthorMTM_JCB(1,"Patel",10001);
		AuthorMTM_JCB a2 = new AuthorMTM_JCB(2,"Durga",11001);
		
		List<AuthorMTM_JCB> li=new ArrayList<AuthorMTM_JCB>();
		li.add(a1);
		li.add(a2);
		
		List<AuthorMTM_JCB> li1=new ArrayList<AuthorMTM_JCB>();
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
@Table
class BookMTM_JCB {

	@Id
	private int bId;
	@Column
	private String bName;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="book_author")
	List<AuthorMTM_JCB> author;

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

	public List<AuthorMTM_JCB> getauthor() {
		return author;
	}

	public void setauthor(List<AuthorMTM_JCB> author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "BookMTM_JCB [bId=" + bId + ", bName=" + bName + ", author=" + author + "]";
	}

	public BookMTM_JCB(int bId, String bName) {
		super();
		this.bId = bId;
		this.bName = bName;
		//this.author = author;
	}

	public BookMTM_JCB() {
		super();
		// TODO Auto-generated constructor stub
	}
		
}

@Entity
@Table
class AuthorMTM_JCB {

	@Id
	private int aId;
	@Column
	private String aName;
	@Column
	private int aPrice;
	
	@ManyToMany(mappedBy="author")
	List<BookMTM_JCB> book;

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

	public List<BookMTM_JCB> getbook() {
		return book;
	}

	public void setauthor(List<BookMTM_JCB> book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "AuthorMTM_JCB [aId=" + aId + ", aName=" + aName + ", aPrice=" + aPrice + ", book=" + book
				+ "]";
	}

	public AuthorMTM_JCB(int aId, String aName, int aPrice) {
		super();
		this.aId = aId;
		this.aName = aName;
		this.aPrice = aPrice;
		//this.book = book;
	}

	public AuthorMTM_JCB() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
}
