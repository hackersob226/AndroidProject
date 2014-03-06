package com.example.memory;

import java.util.Calendar;

public abstract class Transaction {
	private String name;
	private Calendar date;
	private Calendar entryDate;
	private double amount;
	
	Transaction(String name, Calendar date, Calendar entryDate, double amount) {
		this.name = name;
		this.date = date;
		this.entryDate = entryDate;
		this.amount = amount;
	}
	
	String getName() {
		return name;
	}
	
	Calendar getDate() {
		return date;
	}
	
	Calendar getEntryDate() {
		return entryDate;
	}
	
	double getAmount() {
		return amount;
	}
}