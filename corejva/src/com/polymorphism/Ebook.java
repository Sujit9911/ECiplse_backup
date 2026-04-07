package com.polymorphism;

public class Ebook extends LibraryItem {
	String format;
	String filesize;
	@Override
	void displayInfo() {
		printBasicInfo();
		System.out.println("Fromat:"+format);
		System.out.println("Filesize:"+filesize);
	}

}
