package com.example.presenter;

import com.example.memory.IList;
import com.example.memory.Singleton;
import com.example.memory.Tab;
import com.example.memory.Withdrawal;
import com.example.moneycruncher.IWithdrawActivity;

/**
 * @author 
 *
 */
public class WithdrawPresenter extends Presenter {
    /**
     * 
     */
    private Singleton facade;

    /**
     * @param activity 
     * @param list 
     */
    public WithdrawPresenter() {
        facade = Singleton.getInstance();
    }

    public Tab getAccount(String username, String account) {
        return facade.getAccount(username, account);
    }

    /**
     * @param account
     * @return
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
     * @param name 
     * @param category 
     * @param y 
     * @param m 
     * @param d 
     * @param amount 
     * @param account 
     */
    public void withdraw(String name, String category, int y, int m, int d,
	    String amount, Tab account) {
        facade.withdraw(name, category, y, m, d, amount, account);
    }

    public boolean checkNumber(String number) {
        if (number.substring(number.length() - 1).equals(("."))) {
            return true;
        }
        return false;
    }
}
