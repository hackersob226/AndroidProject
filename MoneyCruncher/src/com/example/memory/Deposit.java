package com.example.memory;

import java.util.GregorianCalendar;

/**
 * @author Chase Harland
 *
 */
public class Deposit extends Transaction {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * Represents a deposit on an account.
     *
     * @param name The name of this Transaction
     * @param year The year this of the Transaction
     * @param month the month of the Transaction
     * @param day the day of the Transaction
     * @param amount the amount of the Transaction
     *
     */
    public Deposit(String name, int year, int month,
            int day, double amount) {
        super(name, new GregorianCalendar(year, month, day),
        new GregorianCalendar(), amount);
    }
}