package com.example.memory;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Brandon, Trang, Chase, Katie, Devon 
 *
 */
public class UserList implements IList, Serializable {
    /**
    *
    */
    private static final long serialVersionUID = 1L;
    /**
    *
    */
    private ArrayList<User> myList = new ArrayList<User>();

    /**
     * Constructor for UserList.
     */
    public UserList() {
	myList.add(new User("admin", "pass123"));
    }

    /**
     * @param n The User to be added to the UserList
     */
    public void add(User n) {
	myList.add(n);
    }

    /** 
     * @param n The index of the desired User
     * @return User The requested user
     */
    public User getUser(int n) {
	return myList.get(n);
    }

    /** 
     * @param n The User in question
     * @return boolean whether or not the given User is in the list
     */
    public boolean contains(User n) {
	return myList.contains(n);
    }

    /**
     * @return int The size of the list
     */
    public int getLength() {
	return myList.size();
    }

    /**
     * @return ArrayList<User> An instance of the list
     */
    public ArrayList<User> getList() {
	return myList;
    }
}
