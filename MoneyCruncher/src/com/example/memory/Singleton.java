package com.example.memory;

public class Singleton {
    private static Singleton instance;
    private IList theList;
    
    private Singleton() {
        theList = new UserList();
    }
    
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    
    public IList getList() {
        return theList;
    }
        
}
