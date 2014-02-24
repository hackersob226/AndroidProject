package com.example.memory;

public class Account {
	private String fullName;
	private String displayName;
	private double balance;
	private double monthlyInterestRate;
	
	public Account() {
		
	}
	
	public Account(String fullName, String displayName, double balance, double monthlyInterestRate) {
		this.fullName = fullName;
		this.displayName = displayName;
		this.balance = balance;
		this.monthlyInterestRate = monthlyInterestRate;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	
	public double getbalance() {
		return balance;
	}
	
	public double getMIR() {
		return monthlyInterestRate;
	}
	
	public String toString() {
		return null;
	}

}
