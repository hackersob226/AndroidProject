package com.example.presenter;

import java.util.ArrayList;

import com.example.memory.IList;
import com.example.memory.Tab;

/**
 * @author 
 *
 */
public abstract class Presenter {

    /**
     * 
     */
    public Presenter() {
    }

    /**
     * @param username 
     * @param account 
     * @param myList 
     * @return Tab
     */
    public Tab getAccount(String username, String account, IList myList) {
	ArrayList<Tab> tempAccList = new ArrayList<Tab>();
	for (int n = 0; n < myList.getLength(); n++) {
	    if (myList.getUser(n).getName().equals(username)) {
		tempAccList = myList.getUser(n).getAccList();
	    }
	}
	for (int i = 0; i < tempAccList.size(); i++) {
	    if (tempAccList.get(i).getDisplayName().equals(account)) {
		return tempAccList.get(i);
	    }
	}
	return null;
    }
}
