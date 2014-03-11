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
import com.example.presenter.WithdrawPresenter;

/**
 * @author 
 *
 */
public class WithdrawActivity extends Activity implements IWithdrawActivity {
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
    private EditText mcategory;
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
	setContentView(R.layout.activity_withdraw);

	IList theList = Singleton.getInstance().getList();
	myPresenter = new WithdrawPresenter(this, theList);

	Bundle extras = getIntent().getExtras();
	username = extras.getString("USERNAME");
	account = extras.getString("ACCOUNT");

	currentAccount = myPresenter.getAccount(username, account, theList);

	mreason = (EditText) findViewById(R.id.editText1);
	mreason.setText(reason);

	mcategory = (EditText) findViewById(R.id.editText2);
	mcategory.setText(category);

	mamount = (EditText) findViewById(R.id.editText3);
	mamount.setText(amount);

	datePicker = (DatePicker) findViewById(R.id.datePicker1);

    }

    /**
     * @return boolean
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

	if (TextUtils.isEmpty(category)) {
	    mcategory.setError(getString(R.string.error_field_required));
	    focusView = mcategory;
	    cancel = true;
	}

	int day = datePicker.getDayOfMonth();
	int month = datePicker.getMonth() + 1;
	int year = datePicker.getYear();

	if (TextUtils.isEmpty(amount)) {
	    mamount.setError(getString(R.string.error_field_required));
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
     * @param view 
     */
    public void advance(View view) {
	boolean x = attemptCreate();
	if (x) {
	    Intent intent = new Intent(this, DisplayAccountActivity.class);
	    intent.putExtra("Uniqid", "From_Withdraw_Activity");
	    startActivity(intent);
	}
    }

    /** 
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
	getMenuInflater().inflate(R.menu.withdraw, menu);
	return true;
    }
}
