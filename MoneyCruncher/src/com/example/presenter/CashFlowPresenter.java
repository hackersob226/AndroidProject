package com.example.presenter;

import com.example.memory.Singleton;
import com.example.memory.User;
/**
 * This is the CashFlowPresenter which calls on the Singleton to
 * do all it's work for it.
 * @author Katie, Devon, Brandon, Chase, Trang
 *
 */
public class CashFlowPresenter {
    /**
     * The Singleton used for all business in this presenter.
     */
    private Singleton facade;

    /**
     * Constructor for CashFlowPresenter gets instance of the Singleton.
     */
    public CashFlowPresenter() {
        facade = Singleton.getInstance();
    }

    /**
     * Finds a User using their username.
     * @param username The user's username.
     * @return The found user, or null if it does not exist.
     */
    public User findUser(String username) {
        return facade.findUser(username);
    }
}
