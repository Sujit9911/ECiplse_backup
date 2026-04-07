package com.mock;

public class Parent {
	String name;
	int batch;
	
	void basicinfo() {
		System.out.println("Name:"+name);
		System.out.println("Batch:"+batch);
	}
	void displayinfo() {
		
		
  basicinfo();
		
	}
void primenumber() {
    int num = batch; // using batch as the number to check
    if (num <= 1) {
        System.out.println(num + " is not a prime number");
        return;
    }
    boolean isPrime = true;
    for (int i = 2; i <= Math.sqrt(num); i++) {
        if (num % i == 0) {
            isPrime = false;
            break;
        }
    }
    if (isPrime) {
        System.out.println(num + " is a prime number");
    } else {
        System.out.println(num + " is not a prime number");
    }
}

}