package com.Map.OnetoOne;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class OnetoOneUjt {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		Address a1 =new Address(111,"Pune");
		Address a2 =new Address(112,"Mumbai");
		
		Com con1 = new Com(101,"TCS",a1);
		Com con2 = new Com(102,"BMW",a2);

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tt = ss.beginTransaction();
		
		ss.save(con1);
		ss.save(con2);
		
		tt.commit();
		
		ss.close();
	}

}

@Entity
@Table(name="Com_List")
class Com{
	
	@Id
	@Column
	int comId;
	
	@Column
	String comName;
	

	@OneToOne(cascade=CascadeType.ALL)	
	@JoinTable(name ="Mapping" ,
		 joinColumns=@JoinColumn(name="comId",referencedColumnName="comId"),
	 inverseJoinColumns=@JoinColumn(name="addId",referencedColumnName="addId"))
	Address adds;
	
	public int getComId() {
		return comId;
	}
	public void setComId(int comId) {
		this.comId = comId;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public Address getAdds() {
		return adds;
	}
	public void setAdds(Address adds) {
		this.adds = adds;
	}
	@Override
	public String toString() {
		return "Com [comId=" + comId + ", comName=" + comName + ", adds=" + adds + "]";
	}
	public Com(int comId, String comName, Address adds) {
		super();
		this.comId = comId;
		this.comName = comName;
		this.adds = adds;
	}
	public Com() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}


@Entity
@Table(name="Address_List")
class Address{
	
	@Id
	@Column
	int addId;
	
	@Column
	String addName;
	
	
	public int getAddId() {
		return addId;
	}
	public void setAddId(int addId) {
		this.addId = addId;
	}
	public String getAddName() {
		return addName;
	}
	public void setAddName(String addName) {
		this.addName = addName;
	}
	@Override
	public String toString() {
		return "Address [addId=" + addId + ", addName=" + addName + "]";
	}
	public Address(int addId, String addName) {
		super();
		this.addId = addId;
		this.addName = addName;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}


}
