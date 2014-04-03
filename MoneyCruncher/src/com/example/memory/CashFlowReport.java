package com.example.memory;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author Brandon, Trang, Chase, Katie, Devon
 *
 */
public class CashFlowReport extends AbstractReport {
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
     */
    public static final int MAX_CATEGORIES = 3;

    /**
     * Cash flow extension of Report.
     *
     * @param start The start date of the report
     * @param end The end date of the report
     */
    public CashFlowReport(Calendar start, final Calendar end) {
        startDate = start;
        endDate = end;
    }

    /**
     * @param user The User who owns the account report
     * @return String[] A string list of report elements
     */
    public String[] getDisplayList(final User user) {
        ArrayList<Tab> accList = user.getAccList();
        double deposit = 0;
        double withdraw = 0;

        for (int i = 0; i < accList.size(); i++) {
            ArrayList<Transaction> history = accList.get(i).getHistory();
            for (int n = 0; n < history.size(); n++) {
                Calendar date = history.get(n).getDate();
                if (date.compareTo(startDate) >= 0
                        && date.compareTo(endDate) <= 0) {
                    if (history.get(n) instanceof Deposit) {
                        deposit += history.get(n).getAmount();
                    } else {
                        withdraw += history.get(n).getAmount();
                    }
                }
            }
        }
        String[] displayList = new String[MAX_CATEGORIES];
        displayList[0] = Double.toString(deposit);
        displayList[1] = Double.toString(withdraw);
        displayList[2] = Double.toString(deposit + withdraw);
        return displayList;
    }
}
