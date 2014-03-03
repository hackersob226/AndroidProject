package com.example.presenter;

import com.example.memory.IList;
import com.example.memory.User;
import com.example.memory.UserList;
import com.example.moneycruncher.IRegisterActivity;

public class RegisterPresenter {
    private final IRegisterActivity myActivity;
    private final IList myList;

    public RegisterPresenter(IRegisterActivity activity, IList list) {
        myActivity = activity;
        myList = list;
    }
    
    public boolean checkUser(String mEmail) {
        UserList theList = (UserList)myList;
        for (int i = 0; i < theList.getLength(); i++) {
            if(theList.getUser(i).getName().equals(mEmail)) {
                return true;
            }
        }
        return false;
    }
    
    public void registerUser(String user, String pass) {
        UserList theList = (UserList)myList;
        theList.add(new User(user, pass));
    }
}
