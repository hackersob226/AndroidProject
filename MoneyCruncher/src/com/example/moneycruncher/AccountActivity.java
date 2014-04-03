package com.example.moneycruncher;

import java.io.IOException;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.memory.Tab;
import com.example.memory.User;
import com.example.presenter.AccountListingPresenter;

/**
 * This class is the UI for displaying the accounts a user has
 * and allowing the accounts to be clickable in order to make a 
 * transaction.
 * 
 * @author Katie, Devon, Brandon, Chase, Trang
 */
public class AccountActivity extends Activity {
    /**
     * 
     */
    ListView listView;
    /**
     * 
     */
    User theUser;
    /**
     * 
     */
    public static String user;
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
    private AccountListingPresenter myPresenter;

    /**
     * Overridden method for Activity. All layout information is set up as soon as the
     * activity is created.
     *
     * @param savedInstanceState Default saved instance state.
     */
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_account);

	myPresenter = new AccountListingPresenter();

	String origin = getIntent().getExtras().getString("Uniqid");
	if (origin.equals("From_Login_Activity")) {
	    username = getIntent().getStringExtra(LoginActivity.user);
	}

	listView = (ListView) findViewById(R.id.list);

	ArrayList<Tab> accList = new ArrayList<Tab>();
	theUser = myPresenter.findUser(username);
	accList = theUser.getAccList();

	String[] strList = myPresenter.fillStringList(accList);

	displayAccounts(strList);
	listView.setClickable(true);
	listView.setOnItemClickListener(new OnItemClickListener() {
	    @Override
	    public void onItemClick(AdapterView<?> arg0, View view,
		    int position, long id) {
		Intent intent = new Intent(AccountActivity.this,
			DisplayAccountActivity.class);
		String tempAccount = (String) listView
			.getItemAtPosition(position);

		Bundle extras = new Bundle();
		extras.putString("Uniqid", "From_Account_Activity");
		extras.putString("USERNAME", username);
		extras.putString("ACCOUNT", tempAccount);
		intent.putExtras(extras);

		startActivity(intent);
	    }
	});
    }

    /** 
     * Displays the list of accounts onto the listView.
     * 
     * @param strList List of accounts in String form.
     */
    public void displayAccounts(String[] strList) {
	// ADAPTER
	ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		android.R.layout.simple_list_item_1, strList);
	listView.setAdapter(adapter);
    }

    /**
     * Method to advance to the CreateAccountActivity if selected.
     * 
     * @param view The present View.
     */
    public void create(View view) {
	Intent intent = new Intent(this, CreateAccountActivity.class);
	intent.putExtra(user, username);
	startActivity(intent);
    }

    /**
     * Method to advance to the ReportActivity if selected.
     * 
     * @param view The present View.
     */
    public void generate(View view) {
    if (theUser.getAccList().size() > 0) {
        Intent intent = new Intent(this, ReportActivity.class);
        intent.putExtra("Uniqid", "From_Account_Activity");
        intent.putExtra(user, username);
        startActivity(intent);
    }
    }

    /**
     * Setting for the built-in menu. 
     *
     * @param menu The default Menu.
     */
    public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	menu.add(0, 1, 0, "Sign Out");
	getMenuInflater().inflate(R.menu.account, menu);
	return true;
    }

    /** 
     * Creates functions for the buttons on the built-in menu.
     * 
     * @param item The selected MenuItem.
     * @return Whether or not an item has been selected
     */
    public boolean onOptionsItemSelected(MenuItem item) {
	// Handle item selection
	switch (item.getItemId()) {
	case 1:
        myPresenter.saveBinary();
        Toast.makeText(getApplicationContext(), "Saving...",
                    Toast.LENGTH_LONG).show();
	    Intent intent = new Intent(this, MainActivity.class);
	    startActivity(intent);
	    return true;
	default:
	    return super.onOptionsItemSelected(item);
	}
    }

}

