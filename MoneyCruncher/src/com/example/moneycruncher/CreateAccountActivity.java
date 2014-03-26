package com.example.moneycruncher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.example.memory.IList;
import com.example.memory.Singleton;
import com.example.presenter.CreateAccountPresenter;

/**
 * @author 
 *
 */
public class CreateAccountActivity extends Activity implements
	ICreateAccountActivity {
    /**
     * 
     */
    private String displayName;
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
    private String user;
    /**
     * 
     */
    private CreateAccountPresenter myPresenter;

    // UI references.
    /**
     * 
     */
    private EditText mdisplayName;
    /**
     * 
     */
    private EditText mfullName;
    /**
     * 
     */
    private EditText mbalance;
    /**
     * 
     */
    private EditText minterest;
    /**
     * 
     */
    private boolean cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_create_account);

	myPresenter = new CreateAccountPresenter();

	mdisplayName = (EditText) findViewById(R.id.editText1);
	mdisplayName.setText(displayName);

	mfullName = (EditText) findViewById(R.id.editText2);
	mfullName.setText(fullName);

	mbalance = (EditText) findViewById(R.id.editText3);
	mbalance.setText(balance);

	minterest = (EditText) findViewById(R.id.editText4);
	minterest.setText(interest);

	user = getIntent().getStringExtra(AccountActivity.user);
    }

    /** 
     * @return boolean
     */
    public boolean attemptCreate() {
	View focusView = null;
	mfullName.setError(null);
	mdisplayName.setError(null);
	mbalance.setError(null);
	minterest.setError(null);

	cancel = false;

	fullName = mfullName.getText().toString();
	displayName = mdisplayName.getText().toString();
	balance = mbalance.getText().toString();
	interest = minterest.getText().toString();

	if (TextUtils.isEmpty(displayName)) {
	    mdisplayName.setError(getString(R.string.error_field_required));
	    focusView = mdisplayName;
	    cancel = true;
	} else if (myPresenter.checkDisplayName(displayName)) {
	    mdisplayName.setError(getString(R.string.error_already_exists));
	    focusView = mdisplayName;
	    cancel = true;
	}

	if (TextUtils.isEmpty(fullName)) {
	    mfullName.setError(getString(R.string.error_field_required));
	    focusView = mfullName;
	    cancel = true;
	}

	if (TextUtils.isEmpty(balance)) {
	    mbalance.setError(getString(R.string.error_field_required));
	    focusView = mbalance;
	    cancel = true;
	} else if (myPresenter.checkNumber(balance)){
	    mbalance.setError(getString(R.string.error_invalid_input));
	    focusView = mbalance;
	    cancel = true;
	}

	if (TextUtils.isEmpty(interest)) {
	    minterest.setError(getString(R.string.error_field_required));
	    focusView = minterest;
	    cancel = true;
	} else if (myPresenter.checkNumber(interest)) {
	    minterest.setError(getString(R.string.error_invalid_input));
	    focusView = minterest;
	    cancel = true;
	}

	if (cancel) {
	    focusView.requestFocus();
	} else {
	    myPresenter.createAccount(user, fullName, displayName, balance,
		    interest);
	    return true;
	}
	return false;
    }

    /**
     * 
     * @param view 
     */
    public void goBack(View view) {
	boolean x = attemptCreate();
	if (x) {
	    Intent intent = new Intent(this, AccountActivity.class);
	    intent.putExtra("Uniqid", "From_Create_Account_Activity");
	    startActivity(intent);
	}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.create_account, menu);
	return true;
    }

}
