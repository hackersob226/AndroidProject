package com.example.memory;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author DCryts
 *
 */
public class Tab implements Serializable {
    /**
     *
     */
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
     * @param full The full name of the account
     * @param display The display name of the account
     * @param bal The current balance of the account
     * @param monthlyInterest The monthly interest rate of the account
     */
    public Tab(final String full, final String display, final double bal,
	    final double monthlyInterest) {
        fullName = full;
        displayName = display;
        balance = bal;
        monthlyInterestRate = monthlyInterest;
        history = new ArrayList<Transaction>();
    }

    /**
     * Updates balance and history.
     *
     * @param t the transaction to update the balance and history with
     */
    public final void update(final Transaction t) {
        balance += t.getAmount();
        history.add(t);
    }

    /**
     * @return String The full name of the account
     */
    public final String getFullName() {
    	return fullName;
    }

    /**
     * @return String The display name of the account
     */
    public final String getDisplayName() {
    	return displayName;
    }

    /**
     * @return double The current balance of the account
     */
    public final double getbalance() {
    	return balance;
    }

    /**
     * @return double The monthly interest rate of the account
     */
    public final double getMIR() {
    	return monthlyInterestRate;
    }

    /**
     * @return List<Transaction> The list of Transactions representing
     * the history of the account
     */
    public final ArrayList<Transaction> getHistory() {
    	return history;
    }

    @Override
    public final String toString() {
        String comma = ", ";
        return fullName + comma + displayName + comma + balance + comma
		+ monthlyInterestRate;
    }

}
