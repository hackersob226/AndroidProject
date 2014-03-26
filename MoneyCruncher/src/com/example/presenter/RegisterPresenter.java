package com.example.presenter;

import java.io.IOException;

import android.util.Log;

import com.example.memory.Singleton;

/**
 * @author 
 *
 */
public class RegisterPresenter extends Presenter {
    /**
     * 
     */
    private Singleton facade;

    /**
     * @param activity 
     * @param list 
     */
    public RegisterPresenter() {
        facade = Singleton.getInstance();
    }

    /**
     * @param mEmail 
     * @return boolean
     */
    public boolean checkUser(String mEmail) {
        return facade.verifyRegister(mEmail);
    }

    /**
     * @param user 
     * @param pass 
     */
    public void registerUser(String user, String pass) {
        facade.register(user, pass);
    }

    public void saveBinary() {
        try {
            facade.saveBinary();
        } catch (IOException e) {
            Log.e("ACCOUNT ACTIVITY", "error on closing save binary file");
        }
    }
}
