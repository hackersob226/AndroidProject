package com.example.memory;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author 
 *
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private String name;
    /**
     * 
     */
    private String pass;
    /**
     * 
     */
    private ArrayList<Tab> accList;

    /**
     * @param n 
     * @param p 
     */
    public User(String n, String p) {
	name = n;
	pass = p;
	accList = new ArrayList<Tab>();
    }

    /**
     * @return String
     */
    public String getName() {
	return name;
    }

    /**
     * @return String
     */
    public String getPass() {
	return pass;
    }

    /**
     * @return ArrayList<Tab>
     */
    public ArrayList<Tab> getAccList() {
	return accList;
    }

    /**
     * @param acc 
     */
    public void addAccount(Tab acc) {
	accList.add(acc);
    }

    @Override
    public String toString() {
	return "User: " + name;
    }
}
