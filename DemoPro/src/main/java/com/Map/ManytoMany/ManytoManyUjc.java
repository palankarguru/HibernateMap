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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManytoManyUjc {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			Session s = sf.openSession();
			Transaction t = s.beginTransaction();
			
			DepartmentMTM_JCU d1 = new DepartmentMTM_JCU(11, "Design", "3rd Flour");
			DepartmentMTM_JCU d2 = new DepartmentMTM_JCU(11, "Engine", "3rd Flour");
			DepartmentMTM_JCU d3 = new DepartmentMTM_JCU(12, "Production", "4th Flour");

			CompanyMTM_JCU c1 = new CompanyMTM_JCU(1, "Mahindra");
			CompanyMTM_JCU c2 = new CompanyMTM_JCU(2, "TataMotors");
			
			// company1 have multiple department c1.getDepartment().add(d1);
			 c1.getDepartment().add(d2);
			  
			// company2 have multiple department c2.getDepartment().add(d1);
			  c2.getDepartment().add(d2);
			  c2.getDepartment().add(d3);
				
			s.save(c1);
			s.save(c2);
			t.commit();

					}

	}
@Entity
@Table
class CompanyMTM_JCU {
		@Id
		int id;
		String c_Name;
		@ManyToMany(cascade=CascadeType.ALL)
		@JoinColumn(name="MTMJCUNI")
		
		List<DepartmentMTM_JCU> department=new ArrayList<DepartmentMTM_JCU>();

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
		public List<DepartmentMTM_JCU> getDepartment() {
			return department;
		}

		public void setDepartment(List<DepartmentMTM_JCU> department) {
			this.department = department;
		}

		public CompanyMTM_JCU(int id, String c_Name){
			super();
			this.id = id;
			this.c_Name = c_Name;
			//this.department = department;
		}

		public CompanyMTM_JCU() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "CompanyMTM_JCU [id=" + id + ", c_Name=" + c_Name + ", department=" + department + "]";
		}
			
		
		
}

@Entity
@Table
class DepartmentMTM_JCU {
		@Id
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
		public DepartmentMTM_JCU(int depid, String depName, String depPlace) {
			super();
			this.depid = depid;
			this.depName = depName;
			this.depPlace = depPlace;
		}
		public DepartmentMTM_JCU() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "DepartmentMTM_JCU [depid=" + depid + ", depName=" + depName + ", depPlace=" + depPlace + "]";
		}
		
					
}
