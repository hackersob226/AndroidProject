package com.example.moneycruncher;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.example.presenter.MainPresenter;

/**
 * @author 
 *
 */
public class MainActivity extends Activity {
    private MainPresenter myPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);

    myPresenter = new MainPresenter();

    myPresenter.loadBinary();
    Toast.makeText(getApplicationContext(), "Loading...",
                Toast.LENGTH_LONG).show();
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
