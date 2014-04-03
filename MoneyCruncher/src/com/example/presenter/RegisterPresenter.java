package com.example.presenter;

import java.io.IOException;

import android.util.Log;

import com.example.memory.Singleton;

/**
 * Present for registering an account and handle the 
 * user's actions involved in register account.
 * @author Trang, Katie, Devon, Brandon, Chase.
 *
 */
public class RegisterPresenter extends Presenter {
    /**
     * The Singleton presents the user's information.
     */
    private Singleton facade;

    /**
     * Construct a RegisterPresenter by using an instance
     * of the Singleton 
     */
    public RegisterPresenter() {
        facade = Singleton.getInstance();
    }

    /**
     * Check if the user gives the correct email.
     * @param mEmail user inputs email.
     * @return true if email matched, false otherwise.
     */
    public boolean checkUser(String mEmail) {
        return facade.verifyRegister(mEmail);
    }

    /**
     * The user register for account in Singleton.
     * @param user the user input name.
     * @param pass the user input password.
     */
    public void registerUser(String user, String pass) {
        facade.register(user, pass);
    }
    
    /**
     * Save the user's information in Singleton to the memory.
     */

    public void saveBinary() {
        try {
            facade.saveBinary();
        } catch (IOException e) {
            Log.e("ACCOUNT ACTIVITY", "error on closing save binary file");
        }
    }
}
