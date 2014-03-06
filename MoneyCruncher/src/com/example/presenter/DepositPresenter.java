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

    public void deposit(String name, String date, String amount, Tab account){
        int x,y,z;
        String[] dateNumbers = new String[3];
        dateNumbers = date.split("/");
        x = Integer.parseInt(dateNumbers[0]);
        y = Integer.parseInt(dateNumbers[1]);
        z = Integer.parseInt(dateNumbers[2]);
        double money = Double.parseDouble(amount);
        account.update(new Deposit(name, x, y, z, money));
    }
}