package com.example.memory;

import java.util.ArrayList;
import java.util.Calendar;

public class SpendingCategoryReport extends Report{
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
    public SpendingCategoryReport(Calendar startDate, Calendar endDate) {
        super (startDate, endDate);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * 
     */
    public String[] getDisplayList(User user){
        ArrayList<Tab> accList = user.getAccList();
        double rent = 0, food = 0, clothes = 0, entertainment = 0;

        for (int i = 0; i < accList.size(); i++) {
            ArrayList<Transaction> history = accList.get(i).getHistory();
            for (int n = 0; n < history.size(); n++) {
                if (history.get(n) instanceof Withdrawal) {
                    Calendar date = history.get(n).getDate();
                    if (date.compareTo(startDate) >= 0 && date.compareTo(endDate) <= 0){
                        String category = ((Withdrawal)history.get(n)).getCategory();
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
        String[] displayList = new String[5];
        displayList[0] = Double.toString(rent);
        displayList[1] = Double.toString(food);
        displayList[2] = Double.toString(clothes);
        displayList[3] = Double.toString(entertainment);
        displayList[4] = Double.toString(rent + food + clothes + entertainment);
        return displayList;
    }
}
