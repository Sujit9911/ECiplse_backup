package com.polymorphism;

public class CurrentAccount extends Account{

	 private int withdrawalCount = 0;
		    private  int withdrawalLimit = 4;
	
		    @Override
		    public void withdraw(double amount) {
		        if (withdrawalCount >= withdrawalLimit) {
		            System.out.println("   Withdrawal limit Reached");
		            return;
		        }
	
		        if (amount <= balance) {
		            balance=balance- amount;
		            withdrawalCount++;
		            System.out.println("Withdrawn: " + amount);
		            System.out.println("Withdrawals: " + withdrawalCount);
		        } else {
		            System.out.println("Insufficient funds.");
		        }
		    }
		
	
	
}


