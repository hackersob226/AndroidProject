package com.example.presenter;

import com.example.memory.Singleton;
import com.example.memory.User;

/**
 * This class is the presenter for SpendingCategoryReportActivity
 * so that the activity never has to directly work with the memory.
 * 
 * @author Katie, Devon, Brandon, Chase, Trang
 */
public class SpendingCategoryPresenter {
    /**
     * The Singleton presents the user's information.
     */
    private Singleton facade;

    /**
     *  Construct a SpendingCategoryPresenter by using an instance
     * of the Singleton.
     */
    public SpendingCategoryPresenter() {
        facade = Singleton.getInstance();
    }

    /**
     * Finds the user in the Singleton using the username.
     * @param username The user input username
     * @return User the User found if in Singleton, null otherwise.
     */
    public User findUser(String username) {
        return facade.findUser(username);
    }
}
