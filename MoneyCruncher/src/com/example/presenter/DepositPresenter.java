package com.example.presenter;

import com.example.memory.Deposit;
import com.example.memory.IList;
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
    private final IDepositActivity myActivity;
    /**
     * 
     */
    private final IList myList;

    /**
     * @param activity 
     * @param list 
     */
    public DepositPresenter(IDepositActivity activity, IList list) {
	myActivity = activity;
	myList = list;
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
	double money = Double.parseDouble(amount);
	account.update(new Deposit(name, y, m, d, money));
    }

    public boolean checkNumber(String number) {
        if (number.substring(number.length() - 1).equals(("."))) {
            return true;
        }
        return false;
    }
}