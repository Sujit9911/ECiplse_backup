package com.contruct;

public class Person {
	String name;
	int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
		
		void show() {
			System.out.println("Name=" +name+" Age="+age);
		}
		
	
  public static void main (String[] args) {
	  Person person1=new Person("Sujit",20);
	
	  Person person2= new Person("Gawali",20);
	  person1.show();
	  System.out.println("***********");
	  person2.show();
  }
}
	