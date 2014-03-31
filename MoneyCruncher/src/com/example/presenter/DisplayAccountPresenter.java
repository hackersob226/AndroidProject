package com.example.presenter;

import com.example.memory.IList;
import com.example.memory.Singleton;
import com.example.memory.Tab;
import com.example.moneycruncher.IDisplayAccountActivity;

/**
 * @author 
 *
 */
public class DisplayAccountPresenter extends Presenter {
    /**
     * 
     */
    private Singleton facade;

    /**
     * @param activity 
     * @param list 
     */
    public DisplayAccountPresenter() {
        facade = Singleton.getInstance();
    }

    public Tab getAccount(String account) {
        return facade.getAccount(account);
    }
}
