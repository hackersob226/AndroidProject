package com.example.memory;

import java.util.ArrayList;

public class UserList implements IList{
	private static ArrayList<User> myList = new ArrayList<User>();
	
	static {
	    myList.add(new User("admin", "pass123"));
	}
	
	public void add(User n) {
		myList.add(n);
	}
	
	public User getUser(int n) {
		return myList.get(n);
	}
	
	public boolean contains(User n){
		return myList.contains(n);
	}
	
	public int getLength() {
		return myList.size();
	}
	
	public ArrayList<User> getList(){
		return myList;
	}

}
