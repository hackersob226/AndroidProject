package com.example.presenter;

import com.example.memory.IList;
import com.example.memory.User;
import com.example.moneycruncher.ICashFlowReportActivity;

public class CashFlowPresenter {
    /**
     * 
     */
    private final ICashFlowReportActivity myActivity;
    /**
     * 
     */
    private final IList myList;

    /**
     * @param activity 
     * @param list 
     */
    public CashFlowPresenter(ICashFlowReportActivity activity, IList list) {
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
