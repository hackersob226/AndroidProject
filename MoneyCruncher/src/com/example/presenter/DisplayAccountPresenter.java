package com.example.presenter;

import java.util.ArrayList;

import com.example.memory.IList;
import com.example.memory.Tab;
import com.example.moneycruncher.IDisplayAccountActivity;

public class DisplayAccountPresenter extends Presenter{
    private final IDisplayAccountActivity myActivity;
    private final IList myList;

    public DisplayAccountPresenter(IDisplayAccountActivity activity, IList list) {
        myActivity = activity;
        myList = list;
    }
}
