package com.whileloop;

public class Loop9 {


	public static void main(String[] args) {
		int even=0;
		int odd=0;
		int i=1;
		while(i<=100) {
			if(i%2==0) 
				even=even+i;
			else 
				odd=odd+i;
			i++;
			}
		System.out.println("sum of even"+even);
		System.out.println("sum of odd"+odd);

		}

	}


