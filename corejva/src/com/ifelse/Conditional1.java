package com.ifelse;

public class Conditional1 {
	void check() {
		int x=10;
		if (x%2==0) {
			System.out.println("number is even");
			
			
		}
		else {
			System.out.println("invelid input");
		}
	}
public static void main(String[] args) {
	Conditional1 c1=new Conditional1();
	c1.check();
}
}