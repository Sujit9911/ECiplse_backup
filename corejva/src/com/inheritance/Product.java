package com.inheritance;

public class Product {
	String name;
	String description;
	double price;
	
	void calculateDiscount(double x) {
		double discountedprice=price-x;
		System.out.println("Discounted Price:"+discountedprice);
	}
	void basicinfo() {
		System.out.println("Name:"+name);
		System.out.println("Descript:"+description);
		System.out.println("Price:"+price);
	}
		
	void displayinfo() {
			basicinfo();
			
		}
		
	
	}

