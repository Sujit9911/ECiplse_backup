package com.polymorphism;

public class SavingsAccount extends Account {

	 private int withdrawalCount = 0;
	    private  int withdrawalLimit = 2;

	    @Override
	    public void withdraw(double amount) {
	        if (withdrawalCount >= withdrawalLimit) {
	            System.out.println("Withdrawal limit reached");
	            return;
	        }

	        if (amount <= balance) {
	            balance=balance- amount;
	            withdrawalCount++;
	            System.out.println("Withdrawn: " + amount);
	            System.out.println("WithdrawalS : " + withdrawalCount);
	        } else {
	            System.out.println("Insufficient funds.");
	        }
	    }
	    
	   
	
}

