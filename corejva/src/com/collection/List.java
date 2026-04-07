package com.collection;

import java.util.ArrayList;

public class List {

	public static void main(String[] args) {
ArrayList al=new ArrayList();
al.add(100);
al.add(300);
al.add(200);
al.add(400);
al.add(400);
al.add(500);
System.out.println(al);
System.out.println("*****");
al.remove(5);
System.out.println(al);
System.out.println("*****");

System.out.println(al.size());
System.out.println("*****");
System.out.println(al.isEmpty());

System.out.println("*****");
System.out.println(al.contains(500));
System.out.println(al);
System.out.println("*****");
System.out.println(al.get(1));
System.out.println("******");
al.removeAll(al)	;
System.out.println(al);}

}
