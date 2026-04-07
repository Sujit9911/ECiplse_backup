package com.returnn;

public class operations {

int add(int a,int b) {
	int c=a+b;
	System.out.println("1]Addition ="+c);
	return c;
	
}

	int avg(int p,int q) {

	int z=add(p,q);
	int avgans=z/2;
	 System.out.println("2]Average="+avgans);
	return avgans;
	
}
 int sub(int m,int n) {
	 operations avgans=new operations();
	 int q=avgans.avg(m, n);
	 int sub1=q-1;
	 System.out.println("3]Subtraction ="+sub1);
	 return sub1;
 }
 int multi(int l,int k) {
	 operations sub1=new operations();
	 int w=sub1.sub(l, k);
	 int multi2=w*2;
	 System.out.println("4]Multiplication ="+multi2);
	 return multi2;
 }

 void div(int h,int d) {
	 operations multi2=new operations();
	 int v=multi2.multi(h,d);
	 int div0=v/1;
	 System.out.println("5]Division ="+div0);
	
 }
 public static void main (String[] args) {
	 operations finall=new operations();
	 System.out.println("*****ARITMATIC OPERATIONS******");
	 finall.div(5,6);
	 
 }
}



	 
 