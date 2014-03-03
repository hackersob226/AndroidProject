package com.example.presenter;

import com.example.memory.IList;
import com.example.moneycruncher.IAccountActivity;

public class AccountListingPresenter {
    private final IAccountActivity myActivity;
    private final IList myList;
    
    public AccountListingPresenter(IAccountActivity activity, IList list) {
        myActivity = activity;
        myList = list;
    }
}
