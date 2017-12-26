package com.Map.ManytoMany;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManytoManyUjt {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
			
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			Session s = sf.openSession();
			Transaction t = s.beginTransaction();
			
			DepartmentMTM_JTU d1 = new DepartmentMTM_JTU(11, "Design", "3rd Flour");
			DepartmentMTM_JTU d2 = new DepartmentMTM_JTU(12, "Production", "4th Flour");

			List<DepartmentMTM_JTU> list = new ArrayList<DepartmentMTM_JTU>();
			list.add(d1);
			list.add(d2);

			CompanyMTM_JTU c1 = new CompanyMTM_JTU(1, "Mahindra", list);
			CompanyMTM_JTU c2 = new CompanyMTM_JTU(2, "TataMotors", list);
			
			s.save(c1);
			s.save(c2);

			/*
			 * // company1 have multiple department c1.getDepartment().add(d1);
			 * c1.getDepartment().add(d2);
			 * 
			 * // company2 have multiple department c2.getDepartment().add(d1);
			 * c2.getDepartment().add(d2);
			 */

			t.commit();

			s.close();
			
		
		}

	}

@Entity
@Table(name="com")
class CompanyMTM_JTU {
	@Id
	int id;
	String c_Name;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "MTMJTUNI")
	List<DepartmentMTM_JTU> department=new ArrayList<DepartmentMTM_JTU>();

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

	public List<DepartmentMTM_JTU> getDepartment() {
		return department;
	}

	public void setDepartment(List<DepartmentMTM_JTU> department) {
		this.department = department;
	}

	public CompanyMTM_JTU(int id, String c_Name, List<DepartmentMTM_JTU> department) {
		super();
		this.id = id;
		this.c_Name = c_Name;
		this.department = department;
	}

	public CompanyMTM_JTU() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CompanyMTM_JTU [id=" + id + ", c_Name=" + c_Name + ", department=" + department + "]";
	}

}

@Entity
@Table(name="dept")
class DepartmentMTM_JTU {
	@Id
	int depid;
	String depName;
	String depPlace;

	public DepartmentMTM_JTU(int depid, String depName, String depPlace) {
		super();
		this.depid = depid;
		this.depName = depName;
		this.depPlace = depPlace;

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

	public void setDepPlace(String depPlace) {
		this.depPlace = depPlace;
	}

	public DepartmentMTM_JTU() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DepartmentMTM_JTU [depid=" + depid + ", depName=" + depName + ", depPlace=" + depPlace + "]";
	}

}
