package com.ifelse;

public class Conditional4 {
void sum(int x,int y) {
	if (x%2==0 && y%2==0) {
		int z=x+y;
		System.out.println("Additon is:"+z);
	}
	else {
		System.out.println("enter valid numbers!!!!!");
	}
	
	
	
}
	public static void main(String[] args) {
		Conditional4 c4=new Conditional4();
		c4.sum(10,7);
		

	}

}
