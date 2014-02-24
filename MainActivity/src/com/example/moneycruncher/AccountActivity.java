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
		
		listView = (ListView) findViewById(R.id.list);
		// IS WRONG OK FIX
		ArrayAdapter<ArrayList<User>> adapter = new ArrayAdapter<ArrayList<User>>(this,android.R.layout.simple_list_item_1, android.R.id.text1, theList);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.account, menu);
		return true;
	}

}