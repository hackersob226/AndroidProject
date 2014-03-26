package com.example.presenter;

import com.example.memory.IList;
import com.example.memory.Singleton;
import com.example.memory.User;

public class SpendingCategoryPresenter {
    /**
     * 
     */
    private Singleton facade;

    /**
     * @param activity 
     * @param list 
     */
    public SpendingCategoryPresenter() {
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
