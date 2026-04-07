package com.contruct;

public class LibraryBook {

	String title;
	String author;
	String isbn;
	Boolean available;
	public LibraryBook(String title, String author, String isbn) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.available=true;
	}
	void borrowBook() {
		available=false;
			System.out.println("Book "+title+"Borrowed");
	}
	void returnBook() {
		available=true;
			System.out.println("Book "+title+"Returned");
			
	}
	void show() {
		System.out.println(available);
	}
	public static void main(String[]args) {
		LibraryBook book1=new LibraryBook( "java","sujit","j123");
		LibraryBook book2=new LibraryBook( "java2","gawali","j133");
		book1.borrowBook();
		book1.show();
		book1.returnBook();
		book1.show();
		System.out.println("**************");
		book2.borrowBook();
		book2.show();
		book2.returnBook();
		book1.show();
		System.out.println("**************");
		
		
		
	}
}
