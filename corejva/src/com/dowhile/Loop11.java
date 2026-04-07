package com.dowhile;

public class Loop11 {
	public static void main(String[] args) {
	    int i = 1;

        System.out.println("Even Numbers from 1 to 100:");
        do {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
            i++;
        } while (i <= 100);

        i = 1; 
        System.out.println("\n\nOdd Numbers from 1 to 100:");
        do {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
            i++;
        } while (i <= 100);
    }
}