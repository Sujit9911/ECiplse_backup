package com.ifelse;

public class Conditional3 {
	void sum(int x,int y) {
		if (x%2!=0 && y%2!=0) {
			int z=x+y;
			System.out.println("Addition is "+z);
		}else {
			System.out.println("Enter valid number");
		}
	}

	public static void main(String[] args) {
		Conditional3 c5=new Conditional3();
		c5.sum(21,21 );
	}

}
