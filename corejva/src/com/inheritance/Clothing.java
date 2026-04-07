package com.inheritance;

public class Clothing extends Product {
	int size;
	String color;
	String material;
	
	
	@Override
	void displayinfo() {
		basicinfo();
		System.out.println("Size:"+size);
		System.out.println("Color:"+color);
		System.out.println("Material:"+material);
		
		
	}

}
