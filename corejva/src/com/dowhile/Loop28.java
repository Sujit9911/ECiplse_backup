package com.dowhile;

public class Loop28 {

	public static void main(String[] args) {
		int n1 = 0, n2 = 1, n3;

        System.out.print(n1 + " " + n2 + " "); 
        int i=3;
        do {
        	 n3 = n1 + n2;       // Next term is sum of previous two
             System.out.print(n3 + " ");
             n1 = n2;            // Update n1
             n2 = n3;  
             i++;
		} while (i<=9);
	}

}
