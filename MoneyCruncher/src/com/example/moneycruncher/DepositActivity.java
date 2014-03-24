package com.example.moneycruncher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.memory.IList;
import com.example.memory.Singleton;
import com.example.memory.Tab;
import com.example.presenter.DepositPresenter;

/**
 * @author 
 *
 */
public class DepositActivity extends Activity implements IDepositActivity {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_deposit);

	IList theList = Singleton.getInstance().getList();
	myPresenter = new DepositPresenter(this, theList);

	Bundle extras = getIntent().getExtras();
	username = extras.getString("USERNAME");
	account = extras.getString("ACCOUNT");

	currentAccount = myPresenter.getAccount(username, account, theList);

	msource = (EditText) findViewById(R.id.editText1);
	msource.setText(source);

	mamount = (EditText) findViewById(R.id.editText3);
	mamount.setText(amount);

	datePicker = (DatePicker) findViewById(R.id.datePicker1);
    }

    /**
     * 
     * @return boolean
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
     * 
     * @param view 
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
     * 
     * @param view 
     */
    public void back(View view) {
	Intent intent = new Intent(this, DisplayAccountActivity.class);
	intent.putExtra("Uniqid", "From_Deposit_Activity");
	startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.deposit, menu);
	return true;
    }

}
