package com.collection;
import java.util.ArrayList;

public class Sagar {
void m1() {
	Studdata s=new Studdata();
	ArrayList<Data>list =s.studinfo();
	for (Data data : list) {
	
	if("nsk".equals(data.getCity())) {
		System.out.println(data);
	}}
		
	}
	
	public static void main(String[]args){
		Sagar n=new Sagar();
		n.m1();
	}}
	
