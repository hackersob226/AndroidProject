package com.example.memory;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author
 * 
 */
public interface IList extends Serializable{
    /**
     * @param n 
     */
    void add(User n);

    /**
     * @param n 
     * @return User
     */
    User getUser(int n);

    /**
     * @param n 
     * @return boolean
     */
    boolean contains(User n);

    /**
     * @return int
     */
    int getLength();

    /**
     * @return ArrayList<User>
     */
    ArrayList<User> getList();
}
