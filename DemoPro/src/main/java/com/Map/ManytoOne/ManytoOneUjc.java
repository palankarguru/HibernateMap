package com.Map.ManytoOne;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class ManytoOneUjc {

	public static void main(String[] args) {
		
		@SuppressWarnings("deprecation")
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();

		DepartmentMTO_JCU d1=new DepartmentMTO_JCU(11,"Design", "First_Flour");

	    CompanyMTO_JCU c1=new CompanyMTO_JCU(1, "MANTruck",d1);
	    CompanyMTO_JCU c2=new CompanyMTO_JCU(2, "TataMotors",d1);
	    
	    s.save(c1);
	    s.save(c2);
	    t.commit();

	}

}

@Entity
@Table
class CompanyMTO_JCU{
	@Id
	//@GeneratedValue(strategy=GenerationType.TABLE)
	int id;
	String c_Name;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="COMP_DEPT_MTO")
	DepartmentMTO_JCU department;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getC_Name() {
		return c_Name;
	}

	public void setC_Name(String c_Name) {
		this.c_Name = c_Name;
	}

	public DepartmentMTO_JCU getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentMTO_JCU department) {
		this.department = department;
	}

	public CompanyMTO_JCU(int id, String c_Name, DepartmentMTO_JCU department) {
		super();
		this.id = id;
		this.c_Name = c_Name;
		this.department = department;
	}

	public CompanyMTO_JCU() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CompanyMTO_JCU [id=" + id + ", c_Name=" + c_Name + ", department=" + department + "]";
	}
	
	
}

@Entity
@Table
class DepartmentMTO_JCU {
	@Id
	//@GeneratedValue(strategy=GenerationType.TABLE)
	int depid;
	String depName;
	String depPlace;
	public int getDepid() {
		return depid;
	}
	public void setDepid(int depid) {
		this.depid = depid;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public String getDepPlace() {
		return depPlace;
	}
	public void setDepPlace(String depPlace) {
		this.depPlace = depPlace;
	}
	public DepartmentMTO_JCU(int depid, String depName, String depPlace) {
		super();
		this.depid = depid;
		this.depName = depName;
		this.depPlace = depPlace;
	}
	public DepartmentMTO_JCU() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DepartmentMTO_JCU [depid=" + depid + ", depName=" + depName + ", depPlace=" + depPlace + "]";
	}
	
	
}