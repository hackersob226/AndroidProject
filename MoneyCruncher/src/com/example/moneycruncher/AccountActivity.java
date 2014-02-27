package com.example.moneycruncher;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.memory.Acouch;
import com.example.memory.User;
import com.example.memory.UserList;

public class AccountActivity extends Activity {
	ListView listView;
	public ArrayList<User> theList = UserList.getList();
	public User blah;
	public static String bleh;
	public static int i = 0;
	public static String username;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_account);
		if (i == 0){
			username = getIntent().getStringExtra(LoginActivity.user);
			i++;
		}
		
		listView = (ListView) findViewById(R.id.list);
		ArrayList<Acouch> accList = new ArrayList<Acouch>();
		for (int n = 0; n<theList.size(); n++) {
			if (username.equals(theList.get(n).getName())){
				accList = theList.get(n).getAccList();
				blah = theList.get(n);
			}
		}
		String [] strList =  new String[5];
		if (accList.size() > 0) {
			for (int i = 0; i < accList.size(); i++) {
				strList[i] = accList.get(i).getDisplayName();
			}
		}
		/*
		// LISTVIEW
		listView = (ListView) findViewById(R.id.list);
		String[] strList = new String[theList.size()];
		for (int i=0; i<theList.size();i++) {
			strList[i] = theList.get(i).getName();
		}*/
		// ADAPTER
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, strList);
		listView.setAdapter(adapter);
		
	}
	
	public void create(View view) {
		Intent intent = new Intent(this, CreateAccountActivity.class);
		intent.putExtra(bleh, blah.getName());
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.account, menu);
		return true;
	}

}
/*
 * 
 */

