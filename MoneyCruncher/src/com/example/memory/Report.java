package com.example.memory;

import java.util.Calendar;

public class Report {
    /**
     * 
     */
    private Calendar startDate;
    /**
     * 
     */
    private Calendar endDate;
    /**
     * 
     * @param startDate
     * @param endDate
     */
    Report(Calendar startDate, Calendar endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * 
     * @param user
     * @return
     */
    public String[] getDisplayList(User user) {
        return new String[0];
    }
}
