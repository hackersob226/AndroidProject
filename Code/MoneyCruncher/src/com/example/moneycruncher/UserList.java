package com.example.moneycruncher;

import java.util.ArrayList;

public class UserList {
	private ArrayList<User> myList;
	
	public UserList() {
		myList = new ArrayList<User>();
		User admin = new User("admin", "pass123");
		myList.add(admin);
	}
	
	public User get(int n){
		return myList.get(n);
	}
	
	public int getLength() {
		return myList.size();
	}
}
