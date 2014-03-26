package com.example.memory;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author DCryts
 *
 */
public class Tab implements Serializable{
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private String fullName;
    /**
     * 
     */
    private String displayName;
    /**
     * 
     */
    private double balance;
    /**
     * 
     */
    private double monthlyInterestRate;
    /**
     * 
     */
    private ArrayList<Transaction> history;

    /**
     * @param fullName 
     * @param displayName 
     * @param balance 
     * @param monthlyInterestRate 
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
     * @return String
     */
    public String getFullName() {
	return fullName;
    }

    /**
     * @return String
     */
    public String getDisplayName() {
	return displayName;
    }

    /**
     * @return double
     */
    public double getbalance() {
	return balance;
    }

    /**
     * @return double
     */
    public double getMIR() {
	return monthlyInterestRate;
    }

    /**
     * @return List<Transaction>
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
