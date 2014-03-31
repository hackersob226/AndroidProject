package com.example.memory;

import java.util.Calendar;

/**
 * @author Brandon, Trang, Chase, Katie, Devon
 *
 */
public class Report {
    private Calendar startDate;
    private Calendar endDate;
    
    /**
     * 
     * @param startDate The start date of the report
     * @param endDate The end date of the report
     */
    Report(Calendar startDate, Calendar endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * 
     * @param user The User who owns the account report
     * @return String[] A string list of report elements
     */
    public String[] getDisplayList(User user) {
        return new String[0];
    }
}
