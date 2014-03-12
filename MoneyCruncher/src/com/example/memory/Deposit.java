package com.example.memory;

import java.util.GregorianCalendar;

/**
 * @author
 * 
 */
public class Deposit extends Transaction {

    /**
     * 
     * @param name 
     * @param year 
     * @param month 
     * @param day 
     * @param amount 
     * 
     */
    public Deposit(String name, int year, int month, int day, double amount) {
	super(name, new GregorianCalendar(year, month, day),
		new GregorianCalendar(), amount);
    }
}