package com.Hibernate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "StudDetails")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
// @Inheritance(strategy = InheritanceType.JOINED)
// @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
 @DiscriminatorColumn(name="Parant_Type",
 discriminatorType=DiscriminatorType.STRING)
public class StudentPojo {
	@Id
	 @GeneratedValue(strategy = GenerationType.TABLE)
	private int roll_No;
	@Column
	private String name;

	public StudentPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentPojo(int roll_No, String name) {
		super();
		this.roll_No = roll_No;
		this.name = name;

	}

	@Override
	public String toString() {
		return "StudentPojo [roll_No=" + roll_No + ", name=" + name + "]";
	}

	public int getRoll_No() {
		return roll_No;
	}

	public void setRoll_No(int roll_No) {
		this.roll_No = roll_No;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

@Entity
class Subject extends StudentPojo {
	@Column
	private String subName;

	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subject(String bookname) {
		super();
		subName = bookname;
	}

	

	@Override
	public String toString() {
		return "Subject [Bookname=" + subName + "]";
	}

	public String getBookname() {
		return subName;
	}

	public void setBookname(String bookname) {
		subName = bookname;
	}

}

@Entity
class Books extends StudentPojo {
	@Column
	int book_Id;
	@Column
	String book_Name;

	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Books(int book_Id, String book_Name) {
		super();
		this.book_Id = book_Id;
		this.book_Name = book_Name;
	}

	@Override
	public String toString() {
		return "Books [book_Id=" + book_Id + ", book_Name=" + book_Name + "]";
	}

	public int getBook_Id() {
		return book_Id;
	}

	public void setBook_Id(int book_Id) {
		this.book_Id = book_Id;
	}

	public String getBook_Name() {
		return book_Name;
	}

	public void setBook_Name(String book_Name) {
		this.book_Name = book_Name;
	}

}