package com.Map.OnetoMany;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class OnetoManyBp {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
	
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			Session s = sf.openSession();
			Transaction t = s.beginTransaction();
			
			DepartmentOTM_PKB d1=new DepartmentOTM_PKB(31, "Design", "Ground_Flour", null);
		    DepartmentOTM_PKB d2=new DepartmentOTM_PKB(32,"Production", "2nd_Flour", null);
		    DepartmentOTM_PKB d3=new DepartmentOTM_PKB(33,"Engine", "3rd_Flour",null);
		    DepartmentOTM_PKB d4=new DepartmentOTM_PKB(34,"Maintainance", "4th_Flour", null);
		    
		    CompanyOTM_PKB c1=new CompanyOTM_PKB(1, "MANTruck",null);
		    
		    List<DepartmentOTM_PKB> list=new ArrayList<DepartmentOTM_PKB>();
		    d1.setCompany(c1);
		    d2.setCompany(c1);
		    
		 
		    
		    list.add(d1);
		    list.add(d2);
		    c1.setDepartment(list);
		    
		    
		    CompanyOTM_PKB c2=new CompanyOTM_PKB(2, "TataMotors",null);
		    List<DepartmentOTM_PKB> list1=new ArrayList<DepartmentOTM_PKB>();
		    
		    d3.setCompany(c2);
		    d4.setCompany(c2);
		    list1.add(d3);
		    list1.add(d4);
		       
		    
		    c2.setDepartment(list1);
		  
		      
		    s.save(c1);
		    s.save(c2);
		    

		   
		   System.out.println("Successfully completed");
		   t.commit();
		}

	}

@Entity
@Table(name="COMP")
class CompanyOTM_PKB {
	@Id
	int id;
	String c_Name;
	
	@OneToMany(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	List<DepartmentOTM_PKB> department;
	

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


	public List<DepartmentOTM_PKB> getDepartment() {
		return department;
	}


	public void setDepartment(List<DepartmentOTM_PKB> department) {
		this.department = department;
	}
	

	public CompanyOTM_PKB(int id, String c_Name, List<DepartmentOTM_PKB> department) {
		super();
		this.id = id;
		this.c_Name = c_Name;
		this.department = department;
	}


	public CompanyOTM_PKB() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "CompanyOTM_PKB [id=" + id + ", c_Name=" + c_Name + ", department=" + department + "]";
	}
}


@Entity
@Table(name="Dept")
class DepartmentOTM_PKB {
	@Id
	// @GeneratedValue(strategy=GenerationType.TABLE)
	int depid;
	String depName;
	String depPlace;
	@ManyToOne(cascade=CascadeType.ALL)
	CompanyOTM_PKB company;
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
	public CompanyOTM_PKB getCompany() {
		return company;
	}
	public void setCompany(CompanyOTM_PKB company) {
		this.company = company;
	}
	public DepartmentOTM_PKB(int depid, String depName, String depPlace, CompanyOTM_PKB company) {
		super();
		this.depid = depid;
		this.depName = depName;
		this.depPlace = depPlace;
		this.company = company;
	}
	public DepartmentOTM_PKB() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}	
