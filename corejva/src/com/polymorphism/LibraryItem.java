package com.polymorphism;

public class LibraryItem {
	String tiltle;
	String author;
	String location;
	
	
	void printBasicInfo() {
	System.out.println("Title :"+tiltle);
	System.out.println("Author :"+author);
	System.out.println("Location :"+location);
	}
	void displayInfo() {
		printBasicInfo();
	}

}
