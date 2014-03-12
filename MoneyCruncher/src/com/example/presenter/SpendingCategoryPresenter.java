package com.example.presenter;

import com.example.memory.IList;
import com.example.memory.User;
import com.example.moneycruncher.ISpendingAccountReportActivity;

public class SpendingCategoryPresenter {
    /**
     * 
     */
    private final ISpendingAccountReportActivity myActivity;
    /**
     * 
     */
    private final IList myList;

    /**
     * @param activity 
     * @param list 
     */
    public SpendingCategoryPresenter(ISpendingAccountReportActivity activity, IList list) {
    myActivity = activity;
    myList = list;
    }

    /**
     * @param theList 
     * @param username 
     * @return User
     */
    public User findUser(IList theList, String username) {
    for (int n = 0; n < theList.getLength(); n++) {
        if (username.equals(theList.getUser(n).getName())) {
        return theList.getUser(n);
        }
    }
    return null;
    }
}
