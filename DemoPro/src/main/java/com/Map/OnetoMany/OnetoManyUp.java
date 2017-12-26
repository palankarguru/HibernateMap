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
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class OnetoManyUp {

public static void main(String[] args) {
		
	
			@SuppressWarnings("deprecation")
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			Session s = sf.openSession();
			Transaction t = s.beginTransaction();
			
			DepartmentOTM_PKU d1=new DepartmentOTM_PKU(11,"Design", "First_Flour");
		    DepartmentOTM_PKU d2=new DepartmentOTM_PKU(12,"Production", "2nd_Flour");
		    DepartmentOTM_PKU d3=new DepartmentOTM_PKU(13,"Engine", "3rd_Flour");
		    DepartmentOTM_PKU d4=new DepartmentOTM_PKU(14,"Maintainance", "4th_Flour");
		    
		    List<DepartmentOTM_PKU> list=new ArrayList<DepartmentOTM_PKU>();
		    list.add(d1);
		    list.add(d2);
		    
		    List<DepartmentOTM_PKU> list1=new ArrayList<DepartmentOTM_PKU>();
		    list1.add(d3);
		    list1.add(d4);
		   
		    CompanyOTM_PKU c1=new CompanyOTM_PKU(1, "MANTruck",list);
		    CompanyOTM_PKU c2=new CompanyOTM_PKU(2, "TataMotors",list1);
		    
		    s.save(c1);
		    s.save(c2);
		   
		   
		    System.out.println("Successfully completed");
		   t.commit();


			
		}

	}

@Entity
@Table
class CompanyOTM_PKU{
	@Id
	//@GeneratedValue(strategy=GenerationType.TABLE)
	int id;
	String c_Name;
	
	@OneToMany(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	List<DepartmentOTM_PKU> department;

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

	public List<DepartmentOTM_PKU> getDepartment() {
		return department;
	}

	public void setDepartment(List<DepartmentOTM_PKU> department) {
		this.department = department;
	}

	public CompanyOTM_PKU(int id, String c_Name, List<DepartmentOTM_PKU> department) {
		super();
		this.id = id;
		this.c_Name = c_Name;
		this.department = department;
	}

	public CompanyOTM_PKU() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CompanyOTM_PKU [id=" + id + ", c_Name=" + c_Name + ", department=" + department + "]";
	}
	
	

}
@Entity
@Table
class DepartmentOTM_PKU{
	@Id
	//@GeneratedValue(strategy=GenerationType.TABLE)
	int depid;
	String depName;
	String depPlace;
	public DepartmentOTM_PKU(int depid,String depName, String depPlace) {
		super();
		this.depid = depid;
		this.depName = depName;
		this.depPlace = depPlace;
	}
	public DepartmentOTM_PKU() {
		super();
		// TODO Auto-generated constructor stub
	}
		
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
	public void setDepPlace( String depPlace) {
		this.depPlace = depPlace;
	}
	@Override
	public String toString() {
		return "DepartmentOTM_PKU [depid=" + depid + ", depName=" + depName + ", depPlace=" + depPlace + "]";
	}
	
	
}
