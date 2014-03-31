package com.example.memory;

import java.io.Serializable;
import java.util.Calendar;

/**
 * @author Chase Harland
 *
 */
public abstract class Transaction implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    private Calendar date;
    private Calendar entryDate;
    private double amount;

    /**
     * @param name The name of the Transaction
     * @param date The date the represented transaction was made
     * @param entryDate The date the Transation was initialized and entered
     * @param amount The amount of the Transaction
     */
    Transaction(String name, Calendar date, Calendar entryDate, double amount) {
    	this.name = name;
    	this.date = date;
    	this.entryDate = entryDate;
    	this.amount = amount;
    }

    /**
     * @return String The name of the Transaction
     */
    public String getName() {
    	return name;
    }

    /**
     * @return Calendar The date the represented transaction was made
     */
    public Calendar getDate() {
    	return date;
    }

    /**
     * @return Calendar The date the Transaction was initialized and entered
     */
    public Calendar getEntryDate() {
    	return entryDate;
    }

    /**
     * @return double The amount of the Transaction
     */
    public double getAmount() {
    	return amount;
    }

    @Override
    public String toString() {
    	return name + ", " + date.toString() + ", " + entryDate.toString()
		+ ", " + amount;
    }
}