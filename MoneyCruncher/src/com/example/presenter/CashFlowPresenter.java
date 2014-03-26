package com.example.presenter;

import com.example.memory.IList;
import com.example.memory.Singleton;
import com.example.memory.User;
import com.example.moneycruncher.ICashFlowReportActivity;

public class CashFlowPresenter {
    /**
     * 
     */
    private Singleton facade;

    /**
     * @param activity 
     * @param list 
     */
    public CashFlowPresenter() {
        facade = Singleton.getInstance();
    }

    /**
     * @param theList 
     * @param username 
     * @return User
     */
    public User findUser(String username) {
        return facade.findUser(username);
    }
}
