package com.example.presenter;

import com.example.memory.Singleton;


/**
 * This class presents for creating an account and handles 
 * all the necessary actions involved in creating an account.
 * @author Brandon, Chase, Trang, Katie, Devon
 *
 */
public class CreateAccountPresenter extends Presenter {
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
     * This checks to see if the number is a valid number to enter
     * @param number The number being validated
     * @return true if a valid number, false if not.
     */
    public boolean checkNumber(String number) {
        if (number.substring(number.length() - 1).equals(("."))) {
            return true;
        }
        return false;
    }
    /**
     * This checks to see if the display name is a real display name
     * @param name The Display Name
     * @return true if a real display name, false if not
     */
    public boolean checkDisplayName(String name) {
        return facade.checkDisplayName(name);
    }
}
