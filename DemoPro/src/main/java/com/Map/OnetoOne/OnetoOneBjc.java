package com.Map.OnetoOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.CascadeType;

public class OnetoOneBjc {

	public static void main(String[] args) {

		NewAddress na1 = new NewAddress(11, "ABc", null);
		NewAddress na2 = new NewAddress(12, "Yogesh", null);
		Emp e1 = new Emp(1, "Java", na1);
		Emp e2 = new Emp(2, "Spring", na2);

		na1.setEmp(e1);
		na2.setEmp(e2);
		
		@SuppressWarnings("deprecation")
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		s.save(e1);
		s.save(e2);
		
		t.commit();
		s.close();
	}

}

@Entity
@Table(name = "Emp")
class Emp {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int eId;

	@Column
	private String eName;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private NewAddress add;

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public NewAddress getAdd() {
		return add;
	}

	public void setAdd(NewAddress add) {
		this.add = add;
	}

	@Override
	public String toString() {
		return "Emp [eId=" + eId + ", eName=" + eName + ", add=" + add + "]";
	}

	public Emp(int eId, String eName, NewAddress add) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.add = add;
	}

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

}

@Entity
@Table(name = "New_Add")
class NewAddress {
	@Id
	@Column
	private int aId;

	@Column
	private String aName;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Emp emp;

	public NewAddress(int aId, String aName, Emp emp) {
		super();
		this.aId = aId;
		this.aName = aName;
		this.emp = emp;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

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

	@Override
	public String toString() {
		return "NewAddress [aId=" + aId + ", aName=" + aName + ", emp=" + emp + "]";
	}

	public NewAddress(int aId, String aName) {
		super();
		this.aId = aId;
		this.aName = aName;
	}

	public NewAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

}