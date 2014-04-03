package com.example.memory;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author Brandon, Trang, Chase, Katie, Devon
 *
 */

public class SpendingCategoryReport extends AbstractReport {
    /**
     *
     */
    public static final int MAX_SIZE = 5;
    /**
     *
     */
    private Calendar start;
    /**
     *
     */
    private Calendar end;

    /**
     * Spending report extension of Report.
     *
     * @param startDate The start date of the report
     * @param endDate The end date of the report
     */
    public SpendingCategoryReport(Calendar startDate, Calendar endDate) {
        start = startDate;
        end = endDate;
    }

    /**
     * @param user The User who owns the account report
     * @return String[] A string list of report elements
     */
    public String[] getDisplayList(User user) {
        ArrayList<Tab> accList = user.getAccList();
        double rent = 0;
        double food = 0;
        double clothes = 0;
        double entertainment = 0;

        for (int i = 0; i < accList.size(); i++) {
            ArrayList<Transaction> history = accList.get(i).getHistory();
            for (int n = 0; n < history.size(); n++) {
                if (history.get(n) instanceof Withdrawal) {
                    Calendar date = history.get(n).getDate();
                    if (date.compareTo(start) >= 0
                            && date.compareTo(end) <= 0) {
                        String category = ((Withdrawal)
                                history.get(n)).getCategory();
                        double amount = history.get(n).getAmount();
                        if (category.equals("Rent")) {
                            rent -= amount;
                        } else if (category.equals("Food")) {
                            food -= amount;
                        } else if (category.equals("Clothes")) {
                            clothes -= amount;
                        } else if (category.equals("Entertainment")) {
                            entertainment -= amount;
                        }
                    }
                }
            }
        }
        String[] displayList = new String[MAX_SIZE];
        displayList[0] = Double.toString(rent);
        displayList[1] = Double.toString(food);
        displayList[2] = Double.toString(clothes);
        displayList[3] = Double.toString(entertainment);
        displayList[4] = Double.toString(rent + food + clothes + entertainment);
        return displayList;
    }
}
