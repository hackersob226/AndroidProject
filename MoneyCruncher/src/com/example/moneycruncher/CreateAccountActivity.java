package com.example.moneycruncher;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.example.memory.Acouch;
import com.example.memory.User;
import com.example.memory.UserList;

public class CreateAccountActivity extends Activity {
	private String displayName;
	private String fullName;
	private String balance;
	private String interest;
	private String user;

	// UI references.
	private EditText mdisplayName;
	private EditText mfullName;
	private EditText mbalance;
	private EditText minterest;
	private boolean cancel = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_account);
		
		mdisplayName = (EditText) findViewById(R.id.editText1);
		mdisplayName.setText(displayName);
		
		mfullName = (EditText) findViewById(R.id.editText2);
		mfullName.setText(fullName);
		
		mbalance = (EditText) findViewById(R.id.editText3);
		mbalance.setText(balance);
		
		minterest = (EditText) findViewById(R.id.editText4);
		minterest.setText(interest);
		
		user = getIntent().getStringExtra(AccountActivity.bleh);		
	}
	public boolean attemptCreate(){	
		View focusView = null;
		mfullName.setError(null);
		mdisplayName.setError(null);
		mbalance.setError(null);
		minterest.setError(null);
		
		fullName = mfullName.getText().toString();
		displayName = mdisplayName.getText().toString();
		balance = mbalance.getText().toString();
		interest = minterest.getText().toString();
		
		if (displayName.length()==0) {
			mdisplayName.setError(getString(R.string.error_field_required));
			focusView = mdisplayName;
			cancel = true;
		} 
		
		if (fullName.length() == 0) {
			mfullName.setError(getString(R.string.error_field_required));
			focusView = mfullName;
			cancel = true;
		} 
		
		if (balance.length()==0) {
			mbalance.setError(getString(R.string.error_field_required));
			focusView = mbalance;
			cancel = true;
		} 
		
		if (interest.length() == 0) {
			minterest.setError(getString(R.string.error_field_required));
			focusView = minterest;
			cancel = true;
		}
		
		if (cancel) {
			focusView.requestFocus();
		} else {
			ArrayList<User> theList = UserList.getList();
			for(int i = 0; i < theList.size(); i++) {
					if(theList.get(i).getName().equals(user)){
						theList.get(i).addAccount(new Acouch(fullName,displayName,
									Double.parseDouble(balance), Double.parseDouble(interest)));
					}
			}
			return true;
		}
		return false;
	}
	
	public void goBack(View view) {
		boolean x = attemptCreate();
		if (x) {
		Intent intent = new Intent(this, AccountActivity.class);
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
