package com.example.memory;

import java.util.ArrayList;

/**
 * @author 
 *
 */
public class UserList implements IList {
    /**
     * 
     */
    private static ArrayList<User> myList = new ArrayList<User>();

    static {
	myList.add(new User("admin", "pass123"));
    }

    /**
     * @param n 
     */
    public void add(User n) {
	myList.add(n);
    }

    /** 
     * @param n 
     * @return User
     */
    public User getUser(int n) {
	return myList.get(n);
    }

    /** 
     * @param n 
     * @return boolean
     */
    public boolean contains(User n) {
	return myList.contains(n);
    }

    /** 
     * 
     * @return int
     */
    public int getLength() {
	return myList.size();
    }

    /** 
     * 
     * @return ArrayList<User>
     */
    public ArrayList<User> getList() {
	return myList;
    }

}
