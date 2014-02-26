package com.example.memory;

import java.util.ArrayList;

public class UserList {
	private static ArrayList<User> myList = new ArrayList<User>();
	
	public static void add(User n) {
		myList.add(n);
	}
	
	public static User getUser(int n) {
		return myList.get(n);
	}
	
	public static boolean contains(User n){
		return myList.contains(n);
	}
	
	public static int getLength() {
		return myList.size();
	}
	
	public static ArrayList<User> getList(){
		return myList;
	}

}
