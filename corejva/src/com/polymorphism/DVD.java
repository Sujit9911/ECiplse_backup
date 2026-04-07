package com.polymorphism;

public class DVD extends LibraryItem {
	String director;
	String runTime;
	@Override
	void displayInfo() {
		printBasicInfo();
		System.out.println("Director:"+director);
		System.out.println("Run Time:"+runTime);
	}

}
