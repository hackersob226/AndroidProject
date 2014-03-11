package com.example.memory;

import java.util.Calendar;

/**
 * @author 
 *
 */
public abstract class Transaction {
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
     * @param name 
     * @param date 
     * @param entryDate 
     * @param amount 
     */
    Transaction(String name, Calendar date, Calendar entryDate, double amount) {
	this.name = name;
	this.date = date;
	this.entryDate = entryDate;
	this.amount = amount;
    }

    /**
     * @return String
     */
    public String getName() {
	return name;
    }

    /**
     * @return Calendar
     */
    public Calendar getDate() {
	return date;
    }

    /**
     * @return Calendar
     */
    public Calendar getEntryDate() {
	return entryDate;
    }

    /**
     * @return double
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