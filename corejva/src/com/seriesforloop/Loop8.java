package com.seriesforloop;

public class Loop8 {

	public static void main(String[] args) {
		int n1 = 0, n2 = 1, n3;

        System.out.print(n1 + " " + n2 + " "); // Print first two numbers

        // Generate next 7 terms (total 9 terms in the series)
        for (int i = 3; i <= 9; i++) {
            n3 = n1 + n2;       // Next term is sum of previous two
            System.out.print(n3 + " ");
            n1 = n2;            // Update n1
            n2 = n3;            // Update n2
        }
    }

	}

	/*
	 * //0 + 1 = 1
	 * 
	 * 1 + 1 = 2
	 * 
	 * 1 + 2 = 3
	 * 
	 * 2 + 3 = 5
	 * 
	 * 3 + 5 = 8
	 * 
	 * 5 + 8 = 13
	 * 
	 * 8 + 13 = 21
	 */


