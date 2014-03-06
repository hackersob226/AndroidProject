package com.example.presenter;

import java.util.ArrayList;

import com.example.memory.IList;
import com.example.memory.Tab;
import com.example.memory.User;
import com.example.memory.UserList;
import com.example.moneycruncher.ICreateAccountActivity;

public class CreateAccountPresenter extends Presenter{
    private final ICreateAccountActivity myActivity;
    private final IList myList;

    public CreateAccountPresenter(ICreateAccountActivity activity, IList list) {
        myActivity = activity;
        myList = list;
    }
    
    public void createAccount(String user, String fullName, String displayName, 
            String balance, String interest) {
        UserList theList = (UserList)myList;
        for(int i = 0; i < theList.getLength(); i++) {
            if(theList.getUser(i).getName().equals(user)){
                theList.getUser(i).addAccount(new Tab(fullName,displayName,
                            Double.parseDouble(balance), Double.parseDouble(interest)));
            }
        }
    }
}
