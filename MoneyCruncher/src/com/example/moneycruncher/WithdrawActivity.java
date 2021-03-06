package com.example.moneycruncher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.memory.Tab;
import com.example.presenter.WithdrawPresenter;

/**
 * This class is the UI for making withdrawals.
 * 
 * @author Katie, Devon, Brandon, Chase, Trang
 */
public class WithdrawActivity extends Activity {
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
     * The presenter for the WithdrawActivity.
     */
    private WithdrawPresenter myPresenter;
    /**
     * 
     */
    private String reason;
    /**
     * 
     */
    private String category;
    /**
     * 
     */
    private String amount;

    /**
     * 
     */
    private EditText mreason;
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
     * 
     */
    private Spinner spinner1;
    /**
     *
     */
    private static final String ID = "Uniqid";

    /**
     * Overridden method for Activity. All layout information is set up as soon as the
     * activity is created.
     *
     * @param savedInstanceState Default saved instance state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_withdraw);

	myPresenter = new WithdrawPresenter();

	Bundle extras = getIntent().getExtras();
	username = extras.getString("USERNAME");
	account = extras.getString("ACCOUNT");

	currentAccount = myPresenter.getAccount(account);

	mreason = (EditText) findViewById(R.id.editText1);
	mreason.setText(reason);

	mamount = (EditText) findViewById(R.id.editText3);
	mamount.setText(amount);

	datePicker = (DatePicker) findViewById(R.id.datePicker1);

	addListenerOnSpinnerItemSelection();
    }

    /**
     * Creates a CustomOnItemSelectedListener for the spinner.
     */
    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    /**
     * Creates the layout to input withdraw information. Also checks for
     * incorrect input.
     *
     * @return Whether or not the attempted creation of the transaction is accepted.
     */
    public boolean attemptCreate() {
	View focusView = null;
	mreason.setError(null);
	mamount.setError(null);

	cancel = false;

	reason = mreason.getText().toString();
	amount = mamount.getText().toString();

	if (TextUtils.isEmpty(reason)) {
	    mreason.setError(getString(R.string.error_field_required));
	    focusView = mreason;
	    cancel = true;
	}

	category = String.valueOf(spinner1.getSelectedItem());

	int day = datePicker.getDayOfMonth();
	int month = datePicker.getMonth();
	int year = datePicker.getYear();

	if (TextUtils.isEmpty(amount)) {
	    mamount.setError(getString(R.string.error_field_required));
	    focusView = mamount;
	    cancel = true;
	}  else if (myPresenter.checkNumber(amount)) {
	    mamount.setError(getString(R.string.error_invalid_input));
	    focusView = mamount;
	    cancel = true;
	}  else if (!myPresenter.checkBalance(amount, currentAccount)) {
	    mamount.setError(getString(R.string.error_insufficient_funds));
	    focusView = mamount;
	    cancel = true;
	}

	if (cancel) {
	    focusView.requestFocus();
	} else {
	    myPresenter.withdraw(reason, category, year, month, day, amount,
		    currentAccount);
	    return true;
	}
	return false;
    }

    /** 
     * Method that advances to the DisplayAccountActivity with the transaction being made.
     * 
     * @param view The default View.
     */
    public void advance(View view) {
	boolean x = attemptCreate();
	if (x) {
	    Intent intent = new Intent(this, DisplayAccountActivity.class);
	    intent.putExtra(ID, "From_Withdraw_Activity");
	    startActivity(intent);
	}
    }

    /** 
     * Method that returns to DisplayAccountActivity without the transaction being made.
     * 
     * @param view The default View.
     */
    public void back(View view) {
	Intent intent = new Intent(this, DisplayAccountActivity.class);
	intent.putExtra(ID, "From_Deposit_Activity");
	startActivity(intent);
    }

    /**
     * Setting for the built-in menu. 
     *
     * @param menu The default Menu.
     * @return     Whether or not the Menu was successfully created.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.withdraw, menu);
	return true;
    }
}
