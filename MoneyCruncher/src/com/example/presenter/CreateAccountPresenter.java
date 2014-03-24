package com.example.presenter;

import com.example.memory.IList;
import com.example.memory.Tab;
import com.example.memory.UserList;
import com.example.moneycruncher.ICreateAccountActivity;

/**
 * @author 
 *
 */
public class CreateAccountPresenter extends Presenter {
    /**
     * 
     */
    private final ICreateAccountActivity myActivity;
    /**
     * 
     */
    private final IList myList;

    /**
     * @param activity 
     * @param list 
     */
    public CreateAccountPresenter(ICreateAccountActivity activity, IList list) {
	myActivity = activity;
	myList = list;
    }

    /**
     * @param user 
     * @param fullName 
     * @param displayName 
     * @param balance 
     * @param interest 
     */
    public void createAccount(String user, String fullName, String displayName,
	    String balance, String interest) {
	UserList theList = (UserList) myList;
	for (int i = 0; i < theList.getLength(); i++) {
	    if (theList.getUser(i).getName().equals(user)) {
		theList.getUser(i).addAccount(
			new Tab(fullName, displayName, Double
				.parseDouble(balance), Double
				.parseDouble(interest)));
	        }
	    }
    }

    public boolean checkNumber(String number) {
        if (number.substring(number.length() - 1).equals(("."))) {
            return true;
        }
        return false;
    }
}
