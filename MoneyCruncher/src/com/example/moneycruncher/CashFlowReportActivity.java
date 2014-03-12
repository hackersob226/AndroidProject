package com.example.moneycruncher;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.example.memory.CashFlowReport;
import com.example.memory.IList;
import com.example.memory.Report;
import com.example.memory.Singleton;
import com.example.memory.User;
import com.example.presenter.CashFlowPresenter;

public class CashFlowReportActivity extends Activity implements ICashFlowReportActivity{
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_flow_report);

        IList theList = Singleton.getInstance().getList();
        myPresenter = new CashFlowPresenter(this, theList);

        Bundle extras = getIntent().getExtras();
        String origin = extras.getString("Uniqid");
        if (origin.equals("From_Report_Activity")) {
            username = extras.getString("USERNAME");
            start = extras.getString("STARTDATE");
            end = extras.getString("ENDDATE");
        }

        theUser = myPresenter.findUser(theList, username);
        display();
    }

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.cash_flow_report, menu);
        return true;
    }

}
