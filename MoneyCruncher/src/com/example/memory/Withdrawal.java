package com.example.memory;

import java.util.GregorianCalendar;

/**
 * @author 
 *
 */
public class Withdrawal extends Transaction {
    /**
     * 
     */
    private String category;

    /**
     * @param name 
     * @param category 
     * @param year 
     * @param month 
     * @param day 
     * @param amount 
     */
    public Withdrawal(String name, String category, int year, int month,
	    int day, double amount) {
	super(name, new GregorianCalendar(year, month, day),
		new GregorianCalendar(), -amount);
	this.category = category;
    }

    /**
     * @return String
     */
    public String getCategory() {
	return category;
    }

}