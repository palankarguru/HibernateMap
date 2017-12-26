package com.Map.OnetoOne;

import javax.persistence.CascadeType;
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



public class OnetoOneUjc {

	public static void main(String[] args) {

		Bike1 b1 = new Bike1(101, "Fz", 70000);
		Bike1 b2 = new Bike1(102, "HD", 150000);
		Bike1 b3 = new Bike1(103, "ZMR", 200000);

		Vehicle c1 = new Vehicle(111, "TATA", 100000, b1);
		Vehicle c2 = new Vehicle(222, "Bez", 500000, b2);
		Vehicle c3 = new Vehicle(333, "BMW", 1000000, b3);

		

		@SuppressWarnings("deprecation")
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();

		s.save(c1);
		s.save(c2);
		s.save(c3);

		t.commit();
		s.close();

	}

}

@Entity
@Table(name = "VehicleList")
class Vehicle {
	@Id
	@Column
	 @GeneratedValue(strategy = GenerationType.TABLE)
	private int vehicleId;

	@Column
	private String vehicleName;

	@Column
	private int vehiclePrice;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn

	private Bike1 bk;

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public int getVehiclePrice() {
		return vehiclePrice;
	}

	public void setVehiclePrice(int vehiclePrice) {
		this.vehiclePrice = vehiclePrice;
	}

	public Bike1 getBk() {
		return bk;
	}

	public void setBk(Bike1 bk) {
		this.bk = bk;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleName=" + vehicleName + ", vehiclePrice=" + vehiclePrice
				+ ", bk=" + bk + "]";
	}

	public Vehicle(int vehicleId, String vehicleName, int vehiclePrice, Bike1 bk) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleName = vehicleName;
		this.vehiclePrice = vehiclePrice;
		this.bk = bk;
	}

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}

@Entity
@Table(name = "Bike1_List")
class Bike1 {

	@Id
	@Column

	private int bike1Id;

	@Column
	private String bike1Name;

	@Column
	private int bike1Price;

	public int getBike1Id() {
		return bike1Id;
	}

	public void setBike1Id(int bike1Id) {
		this.bike1Id = bike1Id;
	}

	public String getBike1Name() {
		return bike1Name;
	}

	public void setBike1Name(String bike1Name) {
		this.bike1Name = bike1Name;
	}

	public int getBike1Price() {
		return bike1Price;
	}

	public void setBike1Price(int bike1Price) {
		this.bike1Price = bike1Price;
	}

	@Override
	public String toString() {
		return "Bike1 [bike1Id=" + bike1Id + ", bike1Name=" + bike1Name + ", bike1Price=" + bike1Price + "]";
	}

	public Bike1(int bike1Id, String bike1Name, int bike1Price) {
		super();
		this.bike1Id = bike1Id;
		this.bike1Name = bike1Name;
		this.bike1Price = bike1Price;
	}

	public Bike1() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
