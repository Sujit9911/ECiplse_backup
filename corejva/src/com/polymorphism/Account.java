package com.polymorphism;

public class Account {
	int accountNumber;
	String accountHolder;
	double balance;

	void deposit(double amountt) {
		balance=balance+amountt;
		System.out.println("Deposited:"+amountt);
	}
		
	void withdraw(double amount) {
		if (amount<=balance) {
			balance=balance-amount;
			System.out.println("Withdrawn:"+amount);
			
		}else {
			System.out.println("insuff fund");}
		}
		
		
	void withdraw(double amount,String tranctiontype) {
		if (amount<=balance) {
			balance=balance-amount;
			System.out.println("Withdrawn:"+amount+"Transactiontype :"+tranctiontype);
			
		}else {
			System.out.println("insuff fund");}
		}
		
		void withdraw(double amount,int tranctionId) {
			if (amount<=balance) {
				balance=balance-amount;
				System.out.println("Withdrawn :"+amount+"Tranction Id"+tranctionId);
				
			}else {
				System.out.println("insuff fund");}
		
	}
	void displayAccountInfo() {
		System.out.println("Account Number:"+accountNumber);
		System.out.println("Account Holder:"+accountHolder);
		System.out.println("Account Balance:"+balance);
		
		
		

	}}





	


	


