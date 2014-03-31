package com.example.memory;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author Brandon, Trang, Chase, Katie, Devon
 *
 */
public class CashFlowReport extends Report{
    private Calendar startDate;
    private Calendar endDate;
    
    /**
     * Cash flow extension of Report.
     * 
     * @param startDate The start date of the report
     * @param endDate The end date of the report
     */
    public CashFlowReport(Calendar startDate, Calendar endDate) {
        super(startDate, endDate);
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    /**
     * @param user The User who owns the account report
     * @return String[] A string list of report elements
     */
    public String[] getDisplayList(User user) {
        ArrayList<Tab> accList = user.getAccList();
        double deposit = 0, withdraw = 0;

        for (int i = 0; i < accList.size(); i++) {
            ArrayList<Transaction> history = accList.get(i).getHistory();
            for (int n = 0; n < history.size(); n++) {
                Calendar date = history.get(n).getDate();
                if (date.compareTo(startDate) >= 0 && date.compareTo(endDate) <= 0){
                    if (history.get(n) instanceof Deposit) {
                        deposit += history.get(n).getAmount();
                    } else {
                        withdraw += history.get(n).getAmount();
                    }
                }
            }
        }
        String[] displayList = new String[3];
        displayList[0] = Double.toString(deposit);
        displayList[1] = Double.toString(withdraw);
        displayList[2] = Double.toString(deposit + withdraw);
        return displayList;
    }
}
