package com.keystatic;

public class BankAccount {
	String accountNumber;
	String accountHolder;
	double balance;
	static String bankName;
	public BankAccount(String accountNumber, String accountHolder, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.balance = balance;
	}
	BankAccount(){
		this.accountNumber="Unknown";
		this.accountHolder="Unknown";
		
	}
	{
		BankAccount.bankName="PAISA";
		
		
	}
	
	void deposit(double amount) {
		balance=balance+amount;
		System.out.println("Amount Deposited:"+amount);
	}
	void withdraw(double amount) {
		if (amount<=balance) {
			balance=balance-amount;	
			System.out.println("Amount WithDraw:"+amount);
		}
		else {
		System.out.println("No suff Fund");
		}
	}
	
	
	void printAccountDetails() {

		System.out.println("Account Number:"+accountNumber);
		System.out.println("Account Holder:"+accountHolder);
		System.out.println("Bank Name:"+bankName);
		System.out.println("Bank Balance:"+balance);
		
	}


	public static void main(String[] args) {
		BankAccount b1=new BankAccount();
		BankAccount b2=new BankAccount("b123","Gawali",5000.00);
		b1.deposit(5000);
		b1.printAccountDetails();
		System.out.println("********************************************");
		b2.withdraw(6000);
		b2.printAccountDetails();
				}
}
