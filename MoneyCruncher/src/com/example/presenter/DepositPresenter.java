package com.example.presenter;

import com.example.memory.Deposit;
import com.example.memory.IList;
import com.example.memory.Singleton;
import com.example.memory.Tab;
import com.example.moneycruncher.IDepositActivity;

/**
 * @author 
 *
 */
public class DepositPresenter extends Presenter {
    /**
     * 
     */
    private Singleton facade;

    /**
     * @param activity 
     * @param list 
     */
    public DepositPresenter() {
        facade = Singleton.getInstance();
    }

    public Tab getAccount(String account) {
        return facade.getAccount(account);
    }
    /**
     * @param name 
     * @param y 
     * @param m 
     * @param d 
     * @param amount 
     * @param account 
     */
    public void deposit(String name, int y, int m, int d, String amount,
	    Tab account) {
        facade.deposit(name, y, m , d, amount, account);
    }

    public boolean checkNumber(String number) {
        if (number.substring(number.length() - 1).equals(("."))) {
            return true;
        }
        return false;
    }
}