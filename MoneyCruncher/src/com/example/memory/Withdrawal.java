package com.example.memory;

import java.util.GregorianCalendar;

public class Withdrawal extends Transaction {
	
	public Withdrawal(String name, int year, int month, int day, double amount) {
		super(name, new GregorianCalendar(year, month, day), new GregorianCalendar(), -amount);
	}
	
}