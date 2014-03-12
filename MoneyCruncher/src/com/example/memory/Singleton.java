package com.example.memory;

/**
 * @author
 *
 */
public class Singleton {
    /**
     * 
     */
    private static Singleton instance;
    /**
     * 
     */
    private IList theList;

    /**
     * 
     */
    private Singleton() {
	theList = new UserList();
    }

    /**
     * @return Singleton
     */
    public static synchronized Singleton getInstance() {
	if (instance == null) {
	    instance = new Singleton();
	}
	return instance;
    }

    /**
     * @return IList
     */
    public IList getList() {
	return theList;
    }

}
