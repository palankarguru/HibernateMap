package com.Map.OnetoOne;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OnetoOneBjt {

	public static void main(String[] args) {

		Ven v1 = new Ven(1, "tree", null);
		Ven v2 = new Ven(2, "mango", null);
		 Ven v3 = new Ven(3, "tango", null);

		Cus cus1 = new Cus(11, "moti", null);
		Cus cus2 = new Cus(12, "choti", null);
		 Cus cus3 = new Cus(13, "boti", null);

		@SuppressWarnings("deprecation")
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();

		cus1.setVe(v1);
		cus2.setVe(v2);
		cus3.setVe(v3);
		v1.setC(cus1);
		v2.setC(cus2);
		v2.setC(cus3);
		s.save(v1);
		s.save(v2);
		s.save(v3);
		s.save(cus1);
		s.save(cus2);
		s.save(cus3);

		t.commit();
		s.close();
	}

}

@Entity
@Table(name = "cus_list")
class Cus {
	@Id
	// @GeneratedValue(strategy=GenerationType.AUTO)
	private int cId;
	@Column
	private String cName;
	@OneToOne(mappedBy = "c")
	private Ven ve;

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Ven getVe() {
		return ve;
	}

	public void setVe(Ven ve) {
		this.ve = ve;
	}

	@Override
	public String toString() {
		return "Cus [cId=" + cId + ", cName=" + cName + ", ve=" + ve + "]";
	}

	public Cus(int cId, String cName, Ven ve) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.ve = ve;
	}

	public Cus() {
		super();
		// TODO Auto-generated constructor stub
	}

}

@Entity
@Table(name = "ven_list")
class Ven {
	@Id
	private int vId;
	@Column
	private String vName;
	@OneToOne
	@JoinTable(name = "Cus_Ven")
	private Cus c;

	@Override
	public String toString() {
		return "Ven [vId=" + vId + ", vName=" + vName + ", c=" + c + "]";
	}

	public int getvId() {
		return vId;
	}

	public void setvId(int vId) {
		this.vId = vId;
	}

	public String getvName() {
		return vName;
	}

	public void setvName(String vName) {
		this.vName = vName;
	}

	public Cus getC() {
		return c;
	}

	public void setC(Cus c) {
		this.c = c;
	}

	public Ven(int vId, String vName, Cus c) {
		super();
		this.vId = vId;
		this.vName = vName;
		this.c = c;
	}

	public Ven() {
		super();
		// TODO Auto-generated constructor stub
	}

}