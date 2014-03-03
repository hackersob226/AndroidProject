package com.example.memory;

import java.util.ArrayList;

public class User {
	private String name;
	private String pass;
	private ArrayList<Tab> accList;
	
	public User(String n, String p) {
		name = n;
		pass = p;
		accList = new ArrayList<Tab>();
	}
	
	public String getName() {
		return name;
	}
	
	public String getPass() {
		return pass;
	}
	
	public ArrayList<Tab> getAccList() {
		return accList;
	}
	
	public void addAccount(Tab acc) {
		accList.add(acc);
	}
	
	@Override
	public String toString() {
		return "User: "+name;
	}
}
