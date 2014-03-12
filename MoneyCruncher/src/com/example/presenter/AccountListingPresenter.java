package com.example.presenter;

import java.util.ArrayList;

import com.example.memory.IList;
import com.example.memory.Tab;
import com.example.memory.User;
import com.example.moneycruncher.IAccountActivity;

/**
 * 
 * @author 
 *
 */
public class AccountListingPresenter extends Presenter {
    /**
     * 
     */
    private final IAccountActivity myActivity;
    /**
     * 
     */
    private final IList myList;

    /**
     * @param activity 
     * @param list 
     */
    public AccountListingPresenter(IAccountActivity activity, IList list) {
	myActivity = activity;
	myList = list;
    }

    /**
     * @param theList 
     * @param username 
     * @return User
     */
    public User findUser(IList theList, String username) {
	for (int n = 0; n < theList.getLength(); n++) {
	    if (username.equals(theList.getUser(n).getName())) {
		return theList.getUser(n);
	    }
	}
	return null;
    }

    /**
     * @param accList 
     * @return String[]
     */
    public String[] fillStringList(ArrayList<Tab> accList) {
	String[] strList = new String[accList.size()];
	if (accList.size() > 0) {
	    for (int i = 0; i < accList.size(); i++) {
		strList[i] = accList.get(i).getDisplayName();
	    }
	}
	return strList;
    }
}
