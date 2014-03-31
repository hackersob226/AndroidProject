package com.example.memory;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Brandon, Trang, Chase, Katie, Devon
 *
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String pass;
    private ArrayList<Tab> accList;

    /**
     * @param n the username of the User
     * @param p the password of the User
     */
    public User(String n, String p) {
	name = n;
	pass = p;
	accList = new ArrayList<Tab>();
    }

    /**
     * @return String The username of the User
     */
    public String getName() {
	return name;
    }

    /**
     * @return String The password of the User
     */
    public String getPass() {
	return pass;
    }

    /**
     * @return ArrayList<Tab> The list of accounts of the User
     */
    public ArrayList<Tab> getAccList() {
	return accList;
    }

    /**
     * @param acc The account to be added to the User's acount list
     */
    public void addAccount(Tab acc) {
	accList.add(acc);
    }

    @Override
    public String toString() {
	return "User: " + name;
    }
}
