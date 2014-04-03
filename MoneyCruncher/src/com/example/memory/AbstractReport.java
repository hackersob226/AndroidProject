package com.example.memory;

/**
 * @author Brandon, Trang, Chase, Katie, Devon
 *
 */
public abstract class AbstractReport {

    /**
     *
     * @param user The User who owns the account report
     * @return String[] A string list of report elements
     */
    public abstract String[] getDisplayList(User user);
}
