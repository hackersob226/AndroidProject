package com.example.presenter;

import com.example.memory.Singleton;

/**
 * @author 
 *
 */
public class LoginPresenter extends Presenter {

    /**
     * 
     */
    private Singleton facade;
    /**
     * @param activity 
     * @param list 
     */
    public LoginPresenter() {
        facade = Singleton.getInstance();
    }

    /**
     * @param mPassword 
     * @return boolean
     */
    public boolean checkPassword(String mPassword) {
        return facade.verifyPass(mPassword);
    }

    /**
     * @param mEmail 
     * @return boolean
     */
    public boolean checkUser(String mEmail) {
        return facade.verifyLogin(mEmail);
    }
}
