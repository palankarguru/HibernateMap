package com.mavenproject.DemoPro;

public class MyNode {
	int data;
	MyNode next;

	public MyNode(int data, MyNode next) {
		super();
		this.data = data;
		this.next = next;
	}

	@Override
	public String toString() {
		return "MyNode \n[data=" + data + ", next=" + next + "]";
	}
	

}
