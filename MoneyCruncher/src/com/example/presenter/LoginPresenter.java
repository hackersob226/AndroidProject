package com.example.presenter;

import com.example.memory.IList;
import com.example.memory.UserList;
import com.example.moneycruncher.ILoginActivity;
import com.example.moneycruncher.R;

/**
 * @author 
 *
 */
public class LoginPresenter extends Presenter {
    /**
     * 
     */
    private final ILoginActivity myActivity;
    /**
     * 
     */
    private final IList myList;

    /**
     * @param activity 
     * @param list 
     */
    public LoginPresenter(ILoginActivity activity, IList list) {
	myActivity = activity;
	myList = list;
    }

    /**
     * @param mPassword 
     * @return boolean
     */
    public boolean checkPassword(String mPassword) {
	UserList theList = (UserList) myList;
	for (int n = 0; n < theList.getLength(); n++) {
	    if (mPassword.equals(theList.getUser(n).getPass())) {
		n = theList.getLength();
	    } else if (!mPassword.equals(theList.getUser(n).getPass())
		    && theList.getLength() == 1) {
		return true;
	    } else if (n == theList.getLength() - 1) {
		return true;
	    }
	}
	return false;
    }

    /**
     * @param mEmail 
     * @return boolean
     */
    public boolean checkUser(String mEmail) {
	UserList theList = (UserList) myList;
	for (int i = 0; i < theList.getLength(); i++) {
	    if (mEmail.equals(theList.getUser(i).getName())) {
		i = theList.getLength();
	    } else if (!mEmail.equals(theList.getUser(i).getName())
		    && theList.getLength() == 1) {
		return true;
	    } else if (i == theList.getLength() - 1) {
		return true;
	    }
	}
	return false;
    }
}
