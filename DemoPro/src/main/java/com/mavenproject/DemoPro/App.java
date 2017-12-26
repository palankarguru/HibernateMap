package com.mavenproject.DemoPro;


public class App 
{
    public static void main( String[] args )
    {
    	MyNode mn = new  MyNode(10, null);
    	MyNode mn1 = new  MyNode(20, null);
    	MyNode mn2 = new  MyNode(30, null);
    	MyLinkList mll = new MyLinkList();
    	mll.addNode(mn);
    	mll.addNode(mn1);
    	mll.addNode(mn2);
    System.out.println(mll);
        //System.out.println( "Hello World!" );
    }
}
