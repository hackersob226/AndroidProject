package com.example.moneycruncher;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Spinner;

public class ReportActivity extends Activity{
    private Spinner spinner1;
    private static String username;
    public static String user;
    private DatePicker datePicker1;
    private DatePicker datePicker2;
    private String start;
    private String end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        String origin = getIntent().getExtras().getString("Uniqid");
        if (origin.equals("From_Account_Activity")) {
            username = getIntent().getStringExtra(AccountActivity.user);
        }

        datePicker1 = (DatePicker) findViewById(R.id.datePicker1);
        datePicker2 = (DatePicker) findViewById(R.id.datePicker2);
        addListenerOnSpinnerItemSelection();
    }

    public boolean attemptAdvance() {
        int day = datePicker1.getDayOfMonth();
        int month = datePicker1.getMonth();
        int year = datePicker1.getYear();
        Calendar startDate = new GregorianCalendar(year, month, day);
        day = datePicker2.getDayOfMonth();
        month = datePicker2.getMonth();
        year = datePicker2.getYear();
        Calendar endDate = new GregorianCalendar(year, month, day);
        if (startDate.compareTo(endDate) > 0) {
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        start = sdf.format(startDate.getTime());
        end = sdf.format(endDate.getTime());
        return true;
    }

    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
      }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.report, menu);
        return true;
    }

    public void advance(View view) {
        boolean flag = attemptAdvance();
        String report = String.valueOf(spinner1.getSelectedItem());
        Bundle extras = new Bundle();
        extras.putString("Uniqid", "From_Report_Activity");
        extras.putString("USERNAME", username);
        extras.putString("STARTDATE", start);
        extras.putString("ENDDATE", end);

        if (report.equals("Spending Category Report") && flag) {
            Intent intent = new Intent(this, SpendingCategoryReportActivity.class);
            intent.putExtras(extras);
            startActivity(intent);
        } else if (report.equals("Cash Flow Report") && flag) {
            Intent intent = new Intent(this, CashFlowReportActivity.class);
            intent.putExtras(extras);
            startActivity(intent);
        }
    }

    public void back(View view) {
        Intent intent = new Intent(this, AccountActivity.class);
        intent.putExtra("Uniqid", "From_Report_Activity");
        startActivity(intent);
    }

}
