package com.Map.OnetoOne;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OnetoOneUp {

	public static void main(String[] args) {

		Bike b1 = new Bike(101, "Apache", 70000);
		Bike b2 = new Bike(102, "Bulet", 150000);
		Bike b3 = new Bike(103, "Harly_Dividson", 200000);

		Car c1 = new Car(111, "Santro", 100000, b1);
		Car c2 = new Car(222, "Mercedes_Bez", 500000, b2);
		Car c3 = new Car(333, "Rocyes_Royal", 1000000, b3);

		// b1.setBikeId(c1.getCarId());
		// b2.setBikeId(c2.getCarId());
		// b3.setBikeId(c3.getCarId());

		c1.setCarId(b1.getBikeId());
		c2.setCarId(b2.getBikeId());
		c3.setCarId(b3.getBikeId());

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
@Table(name = "Car_List")
class Car {
	@Id
	@Column
	private int carId;

	@Column
	private String carName;

	@Column
	private int carPrice;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Bike bk;

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public int getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}

	public Bike getBk() {
		return bk;
	}

	public void setBk(Bike bk) {
		this.bk = bk;
	}

	public Car(int carId, String carName, int carPrice, Bike bk) {
		super();
		this.carId = carId;
		this.carName = carName;
		this.carPrice = carPrice;
		this.bk = bk;
	}

	@Override
	public String toString() {
		return "Car [carId=" + carId + ", carName=" + carName + ", carPrice=" + carPrice + ", bk=" + bk + "]";
	}

	public Car() {
		super();

	}

}

@Entity
@Table(name = "Bike_List")
class Bike {

	@Id
	@Column
	private int bikeId;

	@Column
	private String bikeName;

	@Column
	private int bikePrice;

	public int getBikeId() {
		return bikeId;
	}

	public void setBikeId(int bikeId) {
		this.bikeId = bikeId;
	}

	public String getBikeName() {
		return bikeName;
	}

	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}

	public int getBikePrice() {
		return bikePrice;
	}

	public void setBikePrice(int bikePrice) {
		this.bikePrice = bikePrice;
	}

	@Override
	public String toString() {
		return "Bike [bikeId=" + bikeId + ", bikeName=" + bikeName + ", bikePrice=" + bikePrice + "]";
	}

	public Bike() {
		super();

	}

	public Bike(int bikeId, String bikeName, int bikePrice) {
		super();
		this.bikeId = bikeId;
		this.bikeName = bikeName;
		this.bikePrice = bikePrice;
	}

}
