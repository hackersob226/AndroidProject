package com.example.presenter;

import com.example.memory.IList;
import com.example.memory.Tab;
import com.example.memory.Withdrawal;
import com.example.moneycruncher.IWithdrawActivity;

public class WithdrawPresenter extends Presenter{
    private final IWithdrawActivity myActivity;
    private final IList myList;

    public WithdrawPresenter(IWithdrawActivity activity, IList list) {
        myActivity = activity;
        myList = list;
    }

    public void withdraw(String name, int y, int m, int d, String amount, Tab account){
        double money = Double.parseDouble(amount);
        account.update(new Withdrawal(name, y, m , d, money));
    }
}
