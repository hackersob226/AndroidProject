package com.example.memory;

import java.util.ArrayList;

public interface IList {
    void add(User n);
    
    User getUser(int n);
    
    boolean contains(User n);
    
    int getLength();
    
    ArrayList<User> getList();
}
