package com.example.presenter;

import com.example.memory.Singleton;

/**
 * Present the Login status of user and handle 
 * all the given information involved in login.
 * @author Trang, Katie, Brandon, devon, Chase
 *
 */
public class LoginPresenter extends Presenter {

    /**
     * The Singleton presents the user's information
     */
    private Singleton facade;
    /**
     * Construct a LoginPresenter by using an instance
     * of the Singleton
     */
    public LoginPresenter() {
        facade = Singleton.getInstance();
    }

    /**
     * Check the correct password in the Singleton by using mPassword
     * @param mPassword password of the user
     * @return boolean pass the password if found in 
     * the Singleton, error otherwise
     * 
     */
    public boolean checkPassword(String mPassword) {
        return facade.verifyPass(mPassword);
    }

    /**
     * Check the user in Singleton by using mEmail
     * @param mEmail user's email
     * @return boolean user login allowed if found in 
     * the Singleton, null if not found
     */
    public boolean checkUser(String mEmail) {
        return facade.verifyLogin(mEmail);
    }
}
