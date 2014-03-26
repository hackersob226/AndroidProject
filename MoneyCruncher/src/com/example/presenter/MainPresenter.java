package com.example.presenter;

import java.io.IOException;

import android.util.Log;

import com.example.memory.Singleton;

public class MainPresenter extends Presenter {
    /**
     * 
     */
    private Singleton facade;

    /**
     * @param activity 
     * @param list 
     */
    public MainPresenter() {
        facade = Singleton.getInstance();
    }

    public void loadBinary() {
        try {
            facade.loadBinary();
        } catch (IOException e) {
            Log.e("ACCOUNT ACTIVITY", "error on closing save binary file");
        }
    }
}
