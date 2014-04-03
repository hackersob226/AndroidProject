package com.example.presenter;

import com.example.memory.Singleton;
import com.example.memory.Tab;


/**
 * Present for user's withdraw by adding to Singleton
 * to update correct user's information.
 * @author Trang, Brandon, Devon, Chase, Katie 
 *
 */
public class WithdrawPresenter {
    /**
     * The Singleton presents the user's information.
     */
    private Singleton facade;

    /**
     * Construct a WithdrawPresenter by using an
     * instance of Singleton.
     */
    public WithdrawPresenter() {
        facade = Singleton.getInstance();
    }
    
    /**
     * Display the user's account.
     * @param account the user's account.
     * @return account the user's account if found.
     * in Singleton, null otherwise.
     */

    public Tab getAccount(String account) {
        return facade.getAccount(account);
    }

    /**
     * This checks the balance of user which is available or not.
     * @param amount user's current amount in account.
     * @param account user's account.
     * @return false if balance is smaller than the
     * withdraw amount and equal to 0, true otherwise.
     */
    public boolean checkBalance(String amount, Tab account) {
        double input = Double.parseDouble(amount);
        if (account.getbalance() == 0) {
            return false;
        }
        if (account.getbalance() - input < 0) {
            return false;
        }
        return true;
    }

    /**
     * This records in detail of user's withdraw activity to save
     * in Singleton.
     * @param name input the user's name
     * @param category 
     * @param y the current year.
     * @param m the current month.
     * @param d the current date.
     * @param amount the amount user wants to withdraw.
     * @param account the user's account.
     */
    public void withdraw(String name, String category, int y, int m, int d,
	    String amount, Tab account) {
        facade.withdraw(name, category, y, m, d, amount, account);
    }
    
    /**
     * Check if it is the valid input number.
     * @param number validate the number user input.
     * @return true if valid number, false otherwise.
     */

    public boolean checkNumber(String number) {
        if (number.substring(number.length() - 1).equals(("."))) {
            return true;
        }
        return false;
    }
}
