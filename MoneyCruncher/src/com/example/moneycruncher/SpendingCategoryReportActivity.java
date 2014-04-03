package com.example.moneycruncher;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.memory.IList;
import com.example.memory.Report;
import com.example.memory.Singleton;
import com.example.memory.SpendingCategoryReport;
import com.example.memory.User;
import com.example.presenter.SpendingCategoryPresenter;

public class SpendingCategoryReportActivity extends Activity {

    public static String username;
    public static User theUser;
    private String rent;
    /**
     * 
     */
    private String food;
    /**
     * 
     */
    private String clothes;
    /**
     * 
     */
    private String entertainment;
    /**
     * 
     */
    private String total;
    /**
     * 
     */
    private TextView mrent;
    /**
     * 
     */
    private TextView mfood;
    /**
     * 
     */
    private TextView mclothes;
    /**
     * 
     */
    private TextView mentertainment;
    /**
     * 
     */
    private TextView mtotal;
    /**
     * 
     */
    private TextView mdate;
    /**
     * 
     */
    private SpendingCategoryPresenter myPresenter;
    /**
     * 
     */
    private String start = "";
    private String end = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spending_category_report);

        myPresenter = new SpendingCategoryPresenter();

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
        Report spendingReport = new SpendingCategoryReport(startDate, endDate);
        String[] numbers = ((SpendingCategoryReport)spendingReport).getDisplayList(theUser);

        rent = numbers[0];
        food = numbers[1];
        clothes = numbers[2];
        entertainment = numbers[3];
        total = numbers[4];

        mdate = (TextView) findViewById(R.id.textView2);
        mdate.setText(start +" - "+ end);

        mrent = (TextView) findViewById(R.id.textView1);
        mrent.setText(rent);

        mfood = (TextView) findViewById(R.id.textView8);
        mfood.setText(food);

        mclothes = (TextView) findViewById(R.id.textView9);
        mclothes.setText(clothes);

        mentertainment = (TextView) findViewById(R.id.textView10);
        mentertainment.setText(entertainment);

        mtotal = (TextView) findViewById(R.id.textView11);
        mtotal.setText(total);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.spending_category_report, menu);
        return true;
    }

}
