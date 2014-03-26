package com.example.presenter;

import java.io.IOException;
import java.util.ArrayList;

import android.util.Log;
import android.widget.Toast;

import com.example.memory.Singleton;
import com.example.memory.Tab;
import com.example.memory.User;

/**
 * 
 * @author 
 *
 */
public class AccountListingPresenter extends Presenter {
    /**
     * 
     */
    private Singleton facade;

    /**
     * @param activity 
     * @param list 
     */
    public AccountListingPresenter() {
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

    /**
     * @param accList 
     * @return String[]
     */
    public String[] fillStringList(ArrayList<Tab> accList) {
	String[] strList = new String[accList.size()];
	if (accList.size() > 0) {
	    for (int i = 0; i < accList.size(); i++) {
		strList[i] = accList.get(i).getDisplayName();
	    }
	}
	return strList;
    }

    public void saveBinary() {
        try {
            facade.saveBinary();
        } catch (IOException e) {
            Log.e("ACCOUNT ACTIVITY", "error on closing save binary file");
        }
    }
}
