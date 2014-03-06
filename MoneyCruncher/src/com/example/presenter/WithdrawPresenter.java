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

    public void withdraw(String name, String date, String amount, Tab account){
        int x,y,z;
        String[] dateNumbers = new String[3];
        dateNumbers = date.split("/");
        x = Integer.parseInt(dateNumbers[0]);
        y = Integer.parseInt(dateNumbers[1]);
        z = Integer.parseInt(dateNumbers[2]);
        double money = Double.parseDouble(amount);
        account.update(new Withdrawal(name, x, y, z, money));
    }
}
