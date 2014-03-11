package com.example.moneycruncher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

/**
 * @author 
 *
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.main, menu);
	return true;
    }

    /**
     * @param view 
     */
    public void proceed(View view) {
	Intent intent = new Intent(this, LoginActivity.class);
	startActivity(intent);
    }

    /**
     * @param view 
     */
    public void register(View view) {
	Intent intent = new Intent(this, RegisterActivity.class);
	startActivity(intent);
    }
}
