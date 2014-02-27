package com.example.memory;

import java.util.ArrayList;

public class User {
	private String name;
	private String pass;
	private ArrayList<Acouch> accList;
	
	public User(String n, String p) {
		name = n;
		pass = p;
		accList = new ArrayList<Acouch>();
	}
	
	public String getName() {
		return name;
	}
	
	public String getPass() {
		return pass;
	}
	
	public ArrayList<Acouch> getAccList() {
		return accList;
	}
	
	public void addAccount(Acouch acc) {
		accList.add(acc);
	}
	
	@Override
	public String toString() {
		return "User: "+name;
	}
}
