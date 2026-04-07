package com.ifelse;

public class Condidtional3 {
	void check() {
		int x=10;
		int y=20;
		if (x>y) {
			System.out.println(x+" is the largest");
			
		}
		else {
			System.out.println(y+" is the largest");
		}
	}

	public static void main(String[] args) {
		Condidtional3 c3=new Condidtional3();
		c3.check();
	}

}
