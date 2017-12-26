package com.mavenproject.DemoPro;

public class MyLinkList {
	MyNode head;
	MyNode tail;

	public void addNode(MyNode obj) {
		if (head == null) {
			head = obj;
			tail = obj;
		} else {
			tail.next = obj;
			tail = obj;
		}
	}

	@Override
	public String toString() {
		return "MyLinkList [head=" + head + "]";
	}
}