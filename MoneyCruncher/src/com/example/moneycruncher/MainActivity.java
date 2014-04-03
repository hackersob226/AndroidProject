package com.example.moneycruncher;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.example.presenter.MainPresenter;

/**
 * This class is the UI for the main screen of the program allowing the user to
 * proceed to the login page or the register account page.
 * 
 * @author Katie, Devon, Brandon, Chase, Trang
 */
public class MainActivity extends Activity {
    /**
     * The presenter for the MainActivity.
     */
    private MainPresenter myPresenter;
    
    /**
     * Overridden method for Activity. All layout information is set up as soon as the
     * activity is created.
     *
     * @param savedInstanceState Default saved instance state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);

	myPresenter = new MainPresenter();

	myPresenter.loadBinary();
	Toast.makeText(getApplicationContext(), "Loading...",
                Toast.LENGTH_LONG).show();
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
	getMenuInflater().inflate(R.menu.main, menu);
	return true;
    }

    /**
     * Method to advance to the LoginActivity.
     * 
     * @param view The present view.
     */
    public void proceed(View view) {
	Intent intent = new Intent(this, LoginActivity.class);
	startActivity(intent);
    }

    /**
     * Method to advance to the RegisterActivity.
     * 
     * @param view The present view.
     */
    public void register(View view) {
	Intent intent = new Intent(this, RegisterActivity.class);
	startActivity(intent);
    }
}
