package com.example.presenter;

import com.example.memory.Singleton;
import com.example.memory.Tab;

/**
 * 
 * @author Trang, Brandon, Chase, Devon, Katie
 *
 */
public class DisplayAccountPresenter {
    /**
     * The Singleton class used to do actions in the Presenter.
     */
    private Singleton facade;

    /**
     * Constructs a DisplayAccountPresenter by getting the instance of
     * the Singleton.
     */
    public DisplayAccountPresenter() {
        facade = Singleton.getInstance();
    }
    /**
     * Finds an account in the Singleton and returns that Tab.
     * @param account The String of the account's name to be gotten.
     * @return The Tab with the given account name
     */
    public Tab getAccount(String account) {
        return facade.getAccount(account);
    }
}
