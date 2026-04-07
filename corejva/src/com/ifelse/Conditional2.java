package com.ifelse;

public class Conditional2 {
	void check() {
		int b=-2;
		if (b<0) {
			System.out.println("Number is Negative");	
		}
		else if (b>0) {
			System.out.println("Number is positive");
			
		} else {
			System.out.println("NUmber is zero");

		}
	}
public static void main(String[] args) {
	Conditional2 c2=new Conditional2();
	c2.check();
	}
}
