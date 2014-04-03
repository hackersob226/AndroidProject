package com.example.presenter;

import java.io.IOException;
import java.util.ArrayList;

import android.util.Log;

import com.example.memory.Singleton;
import com.example.memory.Tab;
import com.example.memory.User;

/**
 * Presents the Accounts in a list!
 * @author 
 *
 */
public class AccountListingPresenter extends Presenter {
    /**
     * 
     */
    private Singleton facade;

    /**
     * Constructs an AccountListingPresenter using an instance of
     * the Singleton.
     */
    public AccountListingPresenter() {
        facade = Singleton.getInstance();
    }

    /**
     * Finds the user in the Singleton using the username.
     * @param username The user's name
     * @return User the User if found in Singleton, null if not found
     */
    public User findUser(String username) {
        return facade.findUser(username);
    }

    /**
     * Fills a String array with display names of all the 
     * accounts for this user.
     * @param accList the list of accounts
     * @return A String array of account display names
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
    /**
     * 
     */
    public void saveBinary() {
        try {
            facade.saveBinary();
        } catch (IOException e) {
            Log.e("ACCOUNT ACTIVITY", "error on closing save binary file");
        }
    }
}
