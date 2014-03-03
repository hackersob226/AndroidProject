package com.example.moneycruncher;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.memory.IList;
import com.example.memory.Singleton;
import com.example.memory.Tab;
import com.example.memory.User;
import com.example.presenter.AccountListingPresenter;

public class AccountActivity extends Activity implements IAccountActivity{
	ListView listView;
	User theUser;
	public static String user;
	public static String username;
	private AccountListingPresenter myPresenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_account);
		
	    IList theList = Singleton.getInstance().getList();
	    myPresenter = new AccountListingPresenter(this, theList);

		String origin = getIntent().getExtras().getString("Uniqid");
		if (origin.equals("From_Login_Activity")){
	          username = getIntent().getStringExtra(LoginActivity.user);
		}

		listView = (ListView) findViewById(R.id.list);

		ArrayList<Tab> accList = new ArrayList<Tab>();
		theUser = myPresenter.findUser(theList, username);
        accList = theUser.getAccList();

		String [] strList =  myPresenter.fillStringList(accList);
		
		displayAccounts(strList);

		/*
		// Lists the Users.
		// LISTVIEW
		listView = (ListView) findViewById(R.id.list);
		String[] strList = new String[theList.size()];
		for (int i=0; i<theList.size();i++) {
			strList[i] = theList.get(i).getName();
		}*/
	}
	
	public void displayAccounts(String[] strList) {
	    // ADAPTER
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, strList);
        listView.setAdapter(adapter);
	}
	
	public void create(View view) {
		Intent intent = new Intent(this, CreateAccountActivity.class);
		intent.putExtra(user, theUser.getName());
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
	    menu.add(0, 1, 0, "Sign Out");
		getMenuInflater().inflate(R.menu.account, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case 1:
	            Intent intent = new Intent(this, MainActivity.class);
	            startActivity(intent);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

}
/*
 * 
 */

