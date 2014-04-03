package com.example.memory;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Brandon, Trang, Chase, Katie, Devon
 *
 */
public interface IList extends Serializable {
    /**
     * @param n The User to be added
     */
    void add(User n);

    /**
     * @param n The index of the requested user
     * @return User The User requested
     */
    User getUser(int n);

    /**
     * @param n The user in question
     * @return boolean Whether or not the given User is in the list
     */
    boolean contains(User n);

    /**
     * @return int The length of the list
     */
    int getLength();

    /**
     * @return ArrayList<User> An instance of the list
     */
    ArrayList<User> getList();
}
