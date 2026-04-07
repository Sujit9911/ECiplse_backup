package com.keystatic;

public class MathOperations {

	static void add(int a,int b) {
		int sum=a+b;
		
		System.out.println("Addition of "+a+" and "+b+"="+sum);
		
	}
public static void main(String[] args) {
	MathOperations.add(20, 40);
	System.out.println("********************************");
	MathOperations.add(20, 50);
}
}
