package com.example.presenter;

import com.example.memory.Singleton;


/**
 * 
 * @author Brandon, Chase, Trang, Katie, Devon
 *
 */
public class CreateAccountPresenter {
    /**
     * The Singleton used in this class.
     */
    private Singleton facade;

    /**
     * Constructs a CreateAccountPresenter by getting the instance
     * of the Singleton.
     */
    public CreateAccountPresenter() {
        facade = Singleton.getInstance();
    }

    /**
     * Create the account by asking Singleton to create the account.
     * @param user The new User
     * @param fullName The new User's full name
     * @param displayName The new User's display name
     * @param balance The new User's starting balance.
     * @param interest The new user's interest rate.
     */
    public void createAccount(String user, String fullName, String displayName,
	    String balance, String interest) {
        facade.createAccount(user, fullName, displayName, balance, interest);
    }
    /**
     * 
     * @param number The number that is in need of being checked.
     * @return true if, false if
     */
    public boolean checkNumber(String number) {
        if (number.substring(number.length() - 1).equals(("."))) {
            return true;
        }
        return false;
    }
    /**
     * 
     * @param name 
     * @return true if, false if
     */
    public boolean checkDisplayName(String name) {
        return facade.checkDisplayName(name);
    }
}
