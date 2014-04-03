package com.example.moneycruncher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.memory.Tab;
import com.example.presenter.DepositPresenter;

/**
 * This class is the UI for making a deposit.
 * 
 * @author Katie, Devon, Brandon, Chase, Trang
 */
public class DepositActivity extends Activity {
    /**
     * 
     */
    public String account;
    /**
     * 
     */
    public String username;
    /**
     * 
     */
    public Tab currentAccount;

    /**
     * 
     */
    private DepositPresenter myPresenter;
    /**
     * 
     */
    private String source;
    /**
     * 
     */
    private String amount;

    /**
     * 
     */
    private EditText msource;
    /**
     * 
     */
    private EditText mamount;
    /**
     * 
     */
    private boolean cancel;
    /**
     * 
     */
    private DatePicker datePicker;

    /**
     * Overridden method for Activity. All layout information is set up as soon as the
     * activity is created.
     *
     * @param savedInstanceState Default saved instance state.
     */
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_deposit);

	myPresenter = new DepositPresenter();

	Bundle extras = getIntent().getExtras();
	username = extras.getString("USERNAME");
	account = extras.getString("ACCOUNT");

	currentAccount = myPresenter.getAccount(account);

	msource = (EditText) findViewById(R.id.editText1);
	msource.setText(source);

	mamount = (EditText) findViewById(R.id.editText3);
	mamount.setText(amount);

	datePicker = (DatePicker) findViewById(R.id.datePicker1);
    }

    /**
     * Creates the layout to input deposit information. Also checks for
     * incorrect input.
     *
     * @return Whether or not the attempted creation of the transaction is accepted.
     */
    public boolean attemptCreate() {
	View focusView = null;
	msource.setError(null);
	mamount.setError(null);

	cancel = false;

	source = msource.getText().toString();
	amount = mamount.getText().toString();

	if (TextUtils.isEmpty(source)) {
	    msource.setError(getString(R.string.error_field_required));
	    focusView = msource;
	    cancel = true;
	}

	int day = datePicker.getDayOfMonth();
	int month = datePicker.getMonth();
	int year = datePicker.getYear();

	if (TextUtils.isEmpty(amount)) {
	    mamount.setError(getString(R.string.error_field_required));
	    focusView = mamount;
	    cancel = true;
	} else if (myPresenter.checkNumber(amount)) {
	    mamount.setError(getString(R.string.error_invalid_input));
	    focusView = mamount;
	    cancel = true;
	}

	if (cancel) {
	    focusView.requestFocus();
	} else {
	    myPresenter.deposit(source, year, month, day, amount,
		    currentAccount);
	    return true;
	}
	return false;
    }

    /** 
     * Method that advances to the DisplayAccountActivity. Transaction made.
     * 
     * @param view The default View.
     */
    public void advance(View view) {
	boolean x = attemptCreate();
	if (x) {
	    Intent intent = new Intent(this, DisplayAccountActivity.class);
	    intent.putExtra("Uniqid", "From_Deposit_Activity");
	    startActivity(intent);
	}
    }

    /** 
     * Method that returns to DisplayAccountActivity. Transaction not made.
     * 
     * @param view The default View.
     */
    public void back(View view) {
	Intent intent = new Intent(this, DisplayAccountActivity.class);
	intent.putExtra("Uniqid", "From_Deposit_Activity");
	startActivity(intent);
    }

    /**
     * Setting for the built-in menu. 
     *
     * @param menu The default Menu.
     */
    public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.deposit, menu);
	return true;
    }

}
