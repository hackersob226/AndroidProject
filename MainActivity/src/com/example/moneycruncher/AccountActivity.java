package com.example.moneycruncher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.memory.User;
import com.example.memory.UserList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AccountActivity extends Activity {
	ListView listView;
	public ArrayList<User> theList = UserList.getList();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_account);
		
		
		// LISTVIEW
		listView = (ListView) findViewById(R.id.list);
		String[] strList = new String[theList.size()];
		for (int i=0; i<=theList.size();i++) {
			strList[i] = theList.get(i).getName();
		}
		// ADAPTER
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, strList);
		listView.setAdapter(adapter);
		
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

