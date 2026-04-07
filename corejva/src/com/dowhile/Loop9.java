package com.dowhile;

public class Loop9 {

	public static void main(String[] args) {int i = 1;
    int evenSum = 0, oddSum = 0;

    do {
        if (i % 2 == 0)
            evenSum += i;
        else
            oddSum += i;
        i++;
    } while (i <= 100);

    System.out.println("Sum of even numbers from 1 to 100: " + evenSum);
    System.out.println("Sum of odd numbers from 1 to 100: " + oddSum);
}
		
}
