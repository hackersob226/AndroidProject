package com.example.presenter;

import com.example.memory.Singleton;
import com.example.memory.Tab;
import com.example.memory.UserList;

/**
 * @author 
 *
 */
public class CreateAccountPresenter extends Presenter {
    /**
     * 
     */
    private Singleton facade;

    /**
     * @param activity 
     * @param list 
     */
    public CreateAccountPresenter() {
        facade = Singleton.getInstance();
    }

    /**
     * @param user 
     * @param fullName 
     * @param displayName 
     * @param balance 
     * @param interest 
     */
    public void createAccount(String user, String fullName, String displayName,
	    String balance, String interest) {
        facade.createAccount(user, fullName, displayName, balance, interest);
    }

    public boolean checkNumber(String number) {
        if (number.substring(number.length() - 1).equals(("."))) {
            return true;
        }
        return false;
    }

    public boolean checkDisplayName(String name) {
        return facade.checkDisplayName(name);
    }
}
