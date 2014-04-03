package com.example.presenter;

import java.io.IOException;

import android.util.Log;

import com.example.memory.Singleton;

public class MainPresenter extends Presenter {
    /**
     * The Singleton presents the user's information
     */
    private Singleton facade;

    /**
     * Construct a MainPresenter by using an instance
     * of the Singleton 
     */
    public MainPresenter() {
        facade = Singleton.getInstance();
    }
    
    /**
     * Load the information in the Singleton from the phone's memory.
     */

    public void loadBinary() {
        try {
            facade.loadBinary();
        } catch (IOException e) {
            Log.e("ACCOUNT ACTIVITY", "error on closing save binary file");
        }
    }
}
