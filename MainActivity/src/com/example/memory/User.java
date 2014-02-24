package com.example.memory;

import java.util.ArrayList;

public class User {
	private String name;
	private String pass;
	private ArrayList<Account> accList;
	
	public User() {
		
	}
	
	public User(String n, String p) {
		name = n;
		pass = p;
	}
	
	public String getName(){
		return name;
	}
	
	public String getPass(){
		return pass;
	}
}
