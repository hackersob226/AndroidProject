package com.example.memory;

import java.io.Serializable;
import java.util.Calendar;

/**
 * @author Chase Harland
 *
 */
public class Transaction implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
    *
    */
    private String name;
    /**
    *
    */
    private Calendar date;
    /**
    *
    */
    private Calendar entryDate;
    /**
    *
    */
    private double amount;

    /**
     * @param label The name of the Transaction
     * @param day The date the represented transaction was made
     * @param entry The date the Transation was initialized and entered
     * @param money The amount of the Transaction
     */
    Transaction(String label, Calendar day, Calendar entry, double money) {
    	name = label;
    	date = day;
    	entryDate = entry;
    	amount = money;
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
        String comma = ", ";
    	return name + comma + date.toString() + comma + entryDate.toString()
		+ comma + amount;
    }
}