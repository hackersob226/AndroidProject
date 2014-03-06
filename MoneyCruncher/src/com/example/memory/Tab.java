package com.example.memory;

import java.util.List;
import java.util.ArrayList;

public class Tab {
	private String fullName;
	private String displayName;
	private double balance;
	private double monthlyInterestRate;
	private List<Transaction> history;
	
	public Tab(String fullName, String displayName, double balance, double monthlyInterestRate) {
		this.fullName = fullName;
		this.displayName = displayName;
		this.balance = balance;
		this.monthlyInterestRate = monthlyInterestRate;
		history = new ArrayList<Transaction>();
	}
	
	/**
	 * Updates balance and history
	 */
	public void update(Transaction t) {
		balance += t.getAmount();
		history.add(t);
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
	
	public List<Transaction> getHistory() {
		return history;
	}
	
	@Override
	public String toString() {
		return fullName+", "+displayName+", "+balance+", "+monthlyInterestRate;
	}

}
