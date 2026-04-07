package com.polymorphism;

public class Main {
	 public static void main(String[] args) {
		 System.out.println(":::::::::::SAVINGS ACC::::::");
	        SavingsAccount s1 = new SavingsAccount();
	        s1.accountNumber = 1275;
	        s1.accountHolder = "Sujit";
	        s1.deposit(10000);
	        s1.withdraw(100);
	        s1.displayAccountInfo();
	        
	     
	        



	        System.out.println(":::::::::::CURRENT ACC::::::");
	        CurrentAccount s2 = new CurrentAccount();
	        s2.accountNumber = 1285;
	        s2.accountHolder = "SAGAR";
	        s2.deposit(10000);
	        s2.withdraw(200);
	        s2.withdraw(200);
	        s2.withdraw(200);
	        s2.withdraw(200);
	        s2.withdraw(200);
	        s2.displayAccountInfo();
	    
	    }
	}


