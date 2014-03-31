package com.example.memory;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author DCryts
 *
 */
public class Tab implements Serializable{
    private static final long serialVersionUID = 1L;
    private String fullName;
    private String displayName;
    private double balance;
    private double monthlyInterestRate;
    private ArrayList<Transaction> history;

    /**
     * @param fullName The full name of the account
     * @param displayName The display name of the account
     * @param balance The current balance of the account
     * @param monthlyInterestRate The monthly interest rate of the account
     */
    public Tab(String fullName, String displayName, double balance,
	    double monthlyInterestRate) {
		this.fullName = fullName;
		this.displayName = displayName;
		this.balance = balance;
		this.monthlyInterestRate = monthlyInterestRate;
		history = new ArrayList<Transaction>();
    }

    /**
     * Updates balance and history.
     * 
     * @param t the transaction to update the balance and history with
     */
    public void update(Transaction t) {
		balance += t.getAmount();
		history.add(t);
    }

    /**
     * @return String The full name of the account
     */
    public String getFullName() {
    	return fullName;
    }

    /**
     * @return String The display name of the account
     */
    public String getDisplayName() {
    	return displayName;
    }

    /**
     * @return double The current balance of the account
     */
    public double getbalance() {
    	return balance;
    }

    /**
     * @return double The monthly interest rate of the account
     */
    public double getMIR() {
    	return monthlyInterestRate;
    }

    /**
     * @return List<Transaction> The list of Transactions representing the history of the account
     */
    public ArrayList<Transaction> getHistory() {
    	return history;
    }

    @Override
    public String toString() {
	return fullName + ", " + displayName + ", " + balance + ", "
		+ monthlyInterestRate;
    }

}
