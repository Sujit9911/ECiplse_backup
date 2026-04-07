
package com.inheritance;

public class Electronics extends Product {
	String warrantyPeriod;
	String brand;
	@Override
	void displayinfo() {
		basicinfo();
		System.out.println("Warranty Period:"+warrantyPeriod);
		System.out.println("Brand:"+brand);
		
	}
	
	

}
