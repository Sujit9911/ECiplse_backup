package com.mock;

public class Child extends Parent {
	String course;
	String duration;
	
	
	
	@Override
	void displayinfo() {
		basicinfo();
		System.out.println("Course:"+course);
		System.out.println("Duration:"+duration);
		
	}

}
