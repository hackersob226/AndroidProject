package com.example.presenter;

import com.example.memory.Singleton;
import com.example.memory.Tab;

/**
 * This is the presenter for a deposit. Adds the deposit to 
 * a Singleton to let it handle the information correctly.
 * @author Trang, Brandon, Devon, Chase, Katie
 *
 */
public class DepositPresenter extends Presenter {
    /**
     * The Singleton that represents this user's info
     */
    private Singleton facade;

    /**
     * Constructor for a deposit presenter by getting the instance of the Singleton.
     */
    public DepositPresenter() {
        facade = Singleton.getInstance();
    }
    /**
     * Get's the Tab object using the account's name as a String.
     * @param account The string of the account's name.
     * @return The Tab from the Singleton
     */
    public Tab getAccount(String account) {
        return facade.getAccount(account);
    }
    /**
     * This calls on the Singleton to deposit the parameters appropriately.
     * @param name The user's name
     * @param y The deposit date year
     * @param m The deposit date month
     * @param d The deposit date day
     * @param amount The amount to be deposited
     * @param account The account being changed
     */
    public void deposit(String name, int y, int m, int d, String amount,
	    Tab account) {
        facade.deposit(name, y, m , d, amount, account);
    }
    /**
     * This checks to see if the number is a fair one to use.
     * @param number The input number to be validated
     * @return true if valid number, false if not
     */
    public boolean checkNumber(String number) {
        if (number.substring(number.length() - 1).equals(("."))) {
            return true;
        }
        return false;
    }
}