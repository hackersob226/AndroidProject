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
	
	public String getName() {
		return name;
	}
	
	public Calendar getDate() {
		return date;
	}
	
	public Calendar getEntryDate() {
		return entryDate;
	}
	
	public double getAmount() {
		return amount;
	}
	
	@Override
	public String toString() {
		return name+", "+date.toString+", "+entryDate.stoString+", "+amount;
	}
}