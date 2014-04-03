package com.example.memory;

import java.util.GregorianCalendar;

/**
 * @author Chase Harland
 *
 */
public class Withdrawal extends Transaction {
    /**
    *
    */
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    private String category;

    /**
     * @param name The name of the Transaction
     * @param subject The  of the Transaction
     * @param year The year the represented transaction was made
     * @param month The month the the represented transaction was made
     * @param day The day the represented transaction was made
     * @param amount The amount of the Transaction
     */
    public Withdrawal(String name, String subject, int year, int month,
	    int day, double amount) {
	super(name, new GregorianCalendar(year, month, day),
		new GregorianCalendar(), -amount);
	category = subject;
    }

    /**
     * @return String The category of the withdrawal
     */
    public String getCategory() {
	return category;
    }

}