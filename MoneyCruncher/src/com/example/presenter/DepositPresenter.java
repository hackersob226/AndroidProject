package com.example.presenter;

import java.util.ArrayList;

import com.example.memory.Deposit;
import com.example.memory.IList;
import com.example.memory.Tab;
import com.example.moneycruncher.IDepositActivity;

public class DepositPresenter extends Presenter{
    private final IDepositActivity myActivity;
    private final IList myList;

    public DepositPresenter(IDepositActivity activity, IList list) {
        myActivity = activity;
        myList = list;
    }

    public void deposit(String name, int y, int m, int d, String amount, Tab account){
        double money = Double.parseDouble(amount);
        account.update(new Deposit(name, y, m , d, money));
    }
}