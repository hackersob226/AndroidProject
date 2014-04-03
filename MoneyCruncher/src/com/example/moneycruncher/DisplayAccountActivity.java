package com.example.moneycruncher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.example.memory.Tab;
import com.example.presenter.DisplayAccountPresenter;

/**
 * This class is the UI for display account information.
 * 
 * @author Katie, Devon, Brandon, Chase, Trang
 */
public class DisplayAccountActivity extends Activity {
    /**
     * 
     */
    public static Tab currentAccount;
    /**
     * 
     */
    public static String account;
    /**
     * 
     */
    public static String username;
    /**
     * 
     */
    private DisplayAccountPresenter myPresenter;

    /**
     * 
     */
    private String fullName;
    /**
     * 
     */
    private String balance;
    /**
     * 
     */
    private String interest;

    /**
     * 
     */
    private TextView mfullName;
    /**
     * 
     */
    private TextView mbalance;
    /**
     * 
     */
    private TextView minterest;
    /**
     *
     */
    private static final String ID = "Uniqid";
    /**
    *
    */
    private static final String USER = "USERNAME";
   /**
   *
   */
    private static final String ACC = "ACCOUNT";
    

    /**
     * Overridden method for Activity. All layout information is set up as soon as the
     * activity is created.
     *
     * @param savedInstanceState Default saved instance state.
     */
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_display_account);

	myPresenter = new DisplayAccountPresenter();

	Bundle extras = getIntent().getExtras();
	String origin = extras.getString(ID);
	if (origin.equals("From_Account_Activity")) {
	    username = extras.getString(USER);
	    account = extras.getString(ACC);
	}

	currentAccount = myPresenter.getAccount(account);

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

    /** 
     * Method that advances to the DepositActivity.
     * 
     * @param view The default View.
     */
    public void deposit(View view) {
	Intent intent = new Intent(this, DepositActivity.class);
	Bundle extras = new Bundle();
	extras.putString(USER, username);
	extras.putString(ACC, account);
	intent.putExtras(extras);
	startActivity(intent);
    }

    /** 
     * Method that advances to the WithdrawActivity.
     * 
     * @param view The default View.
     */
    public void withdraw(View view) {
	Intent intent = new Intent(this, WithdrawActivity.class);
	Bundle extras = new Bundle();
	extras.putString(USER, username);
	extras.putString(ACC, account);
	intent.putExtras(extras);
	startActivity(intent);
    }

    /** 
     * Method that returns to the list of accounts/AccountActivity.
     * 
     * @param view The default View.
     */
    public void back(View view) {
	Intent intent = new Intent(this, AccountActivity.class);
	intent.putExtra(ID, "From_Display_Account_Activity");
	startActivity(intent);
    }

    /**
     * Setting for the built-in menu. 
     *
     * @param menu The default Menu.
     * @return Whether or not an item has been selected
     */
    public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.display_account, menu);
	return true;
    }

}
