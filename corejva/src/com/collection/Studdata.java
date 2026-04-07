package com.collection;
import java.util.ArrayList;

public class Studdata {

	ArrayList <Data> studinfo( ) {
		Data d1=new Data();
		d1.setName("sujit");
		d1.setCity("nsk");
		d1.setCourse("JAVA");
		d1.setRollno(01);
		
		Data d2=new Data();
		d2.setName("ravi");
		d2.setCity("pune");
		d2.setCourse("c++");
		d2.setRollno(02);
		
		Data d3=new Data();
		d3.setName("sam");
		d3.setCity("nsk");
		d3.setCourse("pth");
		d3.setRollno(03);
		
		Data d4=new Data();
		d4.setName("sunil");
		d4.setCity("mum");
		d4.setCourse("data");
		d4.setRollno(04);
		
		
		
	ArrayList <Data>al=new ArrayList<>();
	al.add(d1);
	al.add(d2);
	al.add(d3);
	al.add(d4);
	return al;}


}
	


