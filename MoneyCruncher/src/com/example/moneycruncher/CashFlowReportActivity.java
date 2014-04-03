package com.example.moneycruncher;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.example.memory.CashFlowReport;
import com.example.memory.Report;
import com.example.memory.User;
import com.example.presenter.CashFlowPresenter;
/**
 * This class is the UI for displaying the Cash Flow of
 * all accounts for a User.
 * 
 * @author Katie, Devon, Brandon, Chase, Trang
 */
public class CashFlowReportActivity extends Activity {
    private CashFlowPresenter myPresenter;
    private static String username;
    private static User theUser;
    private String start;
    private String end;
    private String expenses;
    private String total;
    private String income;
    private TextView mdate;
    private TextView mincome;
    private TextView mexpenses;
    private TextView mtotal;

    /**
     * Overridden method for Activity. All layout information is set up as soon as the
     * activity is created.
     *
     * @param savedInstanceState Default saved instance state.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_flow_report);

        myPresenter = new CashFlowPresenter();

        Bundle extras = getIntent().getExtras();
        String origin = extras.getString("Uniqid");
        if (origin.equals("From_Report_Activity")) {
            username = extras.getString("USERNAME");
            start = extras.getString("STARTDATE");
            end = extras.getString("ENDDATE");
        }

        theUser = myPresenter.findUser(username);
        display();
    }

    /** 
     * Displays the datePicker and textViews.
     */
    public void display() {
        Calendar startDate = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        try {
           startDate.setTime(sdf.parse(start));
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        Calendar endDate = Calendar.getInstance();
        try {
            endDate.setTime(sdf.parse(end));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Report cashFlowReport = new CashFlowReport(startDate, endDate);
        String[] numbers = ((CashFlowReport)cashFlowReport).getDisplayList(theUser);

            income = numbers[0];
            expenses = numbers[1];
            total = numbers[2];

            mdate = (TextView) findViewById(R.id.textView2);
            mdate.setText(start +" - "+ end);

            mincome = (TextView) findViewById(R.id.textView5);
            mincome.setText(income);

            mexpenses = (TextView) findViewById(R.id.textView6);
            mexpenses.setText(expenses);

            mtotal = (TextView) findViewById(R.id.textView7);
            mtotal.setText(total);
    }

    /**
     * Setting for the built-in menu. 
     *
     * @param menu The default Menu.
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.cash_flow_report, menu);
        return true;
    }

}
