package com.polymorphism;

public class Book extends LibraryItem {
String genre;
int numberOfPages;
@Override
void displayInfo() {
	printBasicInfo();
	System.out.println("Genre:"+genre);
	System.out.println("numberOfPages:"+numberOfPages);
	}
}
