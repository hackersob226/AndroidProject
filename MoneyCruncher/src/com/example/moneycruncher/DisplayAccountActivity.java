package com.example.moneycruncher;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.example.memory.IList;
import com.example.memory.Singleton;
import com.example.memory.Tab;
import com.example.presenter.DisplayAccountPresenter;

public class DisplayAccountActivity extends Activity implements IDisplayAccountActivity{
    public static Tab currentAccount;
    public static String account;
    public static String username;
    private DisplayAccountPresenter myPresenter;

    private String fullName;
    private String balance;
    private String interest;

    private TextView mfullName;
    private TextView mbalance;
    private TextView minterest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_account);

        IList theList = Singleton.getInstance().getList();
        myPresenter = new DisplayAccountPresenter(this, theList);

        Bundle extras = getIntent().getExtras();
        String origin = extras.getString("Uniqid");
        if (origin.equals("From_Account_Activity")){
            username = extras.getString("USERNAME");
            account = extras.getString("ACCOUNT");
        }

        currentAccount = myPresenter.getAccount(username, account);

        fullName = currentAccount.getFullName();
        balance = String.valueOf(currentAccount.getbalance());
        interest = String.valueOf(currentAccount.getMIR());
        
        setTitle(currentAccount.getDisplayName());
        
        mfullName = (TextView) findViewById(R.id.tempView5);
        mfullName.setText(fullName);
        
        mbalance = (TextView) findViewById(R.id.tempView2);
        mbalance.setText(balance);
        
        minterest = (TextView) findViewById(R.id.tempView4);
        minterest.setText(interest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.display_account, menu);
        return true;
    }

}