package com.example.moneycruncher;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.presenter.RegisterPresenter;

/**
 * Activity which displays a register screen to the user.
 * 
 * @author Katie, Devon, Brandon, Chase, Trang
 */
public class RegisterActivity extends Activity {

    /**
     * The presenter for the RegisterActivity.
     */
    private RegisterPresenter myPresenter;

    /**
     * The default email/username to populate the email field with.
     */
    public static final String EXTRA_EMAIL = "com.example.android.authenticatordemo.extra.EMAIL";

     /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
    private UserLoginTask mAuthTask = null;

    /**
     * Variable to store the username at the time of the login attempt.
     */
    private String mEmail;
    /**
     * Variable to store the password at the time of the login attempt.
     */
    private String mPassword;

    // UI references.
    /**
     * The text view for the username.
     */
    private EditText mEmailView;
    /**
     * The text view for the password.
     */
    private EditText mPasswordView;
    /**
     * 
     */
    private View mLoginFormView;
    /**
     * 
     */
    private View mLoginStatusView;
    /**
     * 
     */
    private TextView mLoginStatusMessageView;

    
    /**
     * Overridden method for Activity. All layout information is set up as soon as the
     * activity is created.
     *
     * @param savedInstanceState Default saved instance state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	setContentView(R.layout.activity_register);

	myPresenter = new RegisterPresenter();

	// Set up the login form.
	mEmail = getIntent().getStringExtra(EXTRA_EMAIL);
	mEmailView = (EditText) findViewById(R.id.email);
	mEmailView.setText(mEmail);

	mPasswordView = (EditText) findViewById(R.id.password);
	mPasswordView
		.setOnEditorActionListener(new TextView.OnEditorActionListener() {
		    @Override
		    public boolean onEditorAction(TextView textView, int id,
			    KeyEvent keyEvent) {
			if (id == R.id.login || id == EditorInfo.IME_NULL) {
			    attemptLogin();
			    return true;
			}
			return false;
		    }
		});

	mLoginFormView = findViewById(R.id.login_form);
	mLoginStatusView = findViewById(R.id.login_status);
	mLoginStatusMessageView = (TextView) findViewById(R.id.login_status_message);

	findViewById(R.id.sign_in_button).setOnClickListener(
		new View.OnClickListener() {
		    @Override
		    public void onClick(View view) {
			attemptLogin();
		    }
		});
    }

    /**
     * Setting for the built-in menu. 
     *
     * @param menu The default Menu.
     * @return     Whether or not the Menu was successfully created.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	super.onCreateOptionsMenu(menu);
	getMenuInflater().inflate(R.menu.register, menu);
	return true;
    }

    /**
     * Attempts to register the account specified by the login form.
     * If there are form errors (invalid username, missing fields, etc.), the
     * errors are presented and no actual register attempt is made.
     */
    public void attemptLogin() {
	if (mAuthTask != null) {
	    return;
	}

	// Reset errors.
	mEmailView.setError(null);
	mPasswordView.setError(null);

	// Store values at the time of the login attempt.
	mEmail = mEmailView.getText().toString();
	mPassword = mPasswordView.getText().toString();

	boolean cancel = false;
	View focusView = null;

	// Check for a valid password.
	if (TextUtils.isEmpty(mPassword)) {
	    mPasswordView.setError(getString(R.string.error_field_required));
	    focusView = mPasswordView;
	    cancel = true;
	} else if (mPassword.length() < 4) {
	    mPasswordView.setError(getString(R.string.error_invalid_password));
	    focusView = mPasswordView;
	    cancel = true;
	}

	// Check for a valid email address.
	if (TextUtils.isEmpty(mEmail)) {
	    mEmailView.setError(getString(R.string.error_field_required));
	    focusView = mEmailView;
	    cancel = true;
	} else if (myPresenter.checkUser(mEmail)) {
	    mEmailView.setError(getString(R.string.error_invalid_mamail));
	    focusView = mEmailView;
	    cancel = true;
	}

	if (cancel) {
	    // There was an error; don't attempt login and focus the first
	    // form field with an error.
	    focusView.requestFocus();
	} else {
	    // Show a progress spinner, and kick off a background task to
	    // perform the user login attempt.
	    mLoginStatusMessageView.setText(R.string.login_progress);
	    showProgress(true);

	    myPresenter.registerUser(mEmail, mPassword);

	    mAuthTask = new UserLoginTask();
	    mAuthTask.execute((Void) null);

	    myPresenter.saveBinary();
	    Toast.makeText(getApplicationContext(), "Saving...",
                    Toast.LENGTH_LONG).show();
	    Intent intent = new Intent(this, MainActivity.class);
	    startActivity(intent);
	}
    }

    /**
     * Shows the progress UI and hides the login form.
     * 
     * @param show 
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
	// On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
	// for very easy animations. If available, use these APIs to fade-in
	// the progress spinner.
	if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
	    int shortAnimTime = getResources().getInteger(
		    android.R.integer.config_shortAnimTime);

	    mLoginStatusView.setVisibility(View.VISIBLE);
	    mLoginStatusView.animate().setDuration(shortAnimTime)
		    .alpha(show ? 1 : 0)
		    .setListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
			    mLoginStatusView.setVisibility(show ? View.VISIBLE
				    : View.GONE);
			}
		    });

	    mLoginFormView.setVisibility(View.VISIBLE);
	    mLoginFormView.animate().setDuration(shortAnimTime)
		    .alpha(show ? 0 : 1)
		    .setListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
			    mLoginFormView.setVisibility(show ? View.GONE
				    : View.VISIBLE);
			}
		    });
	} else {
	    // The ViewPropertyAnimator APIs are not available, so simply show
	    // and hide the relevant UI components.
	    mLoginStatusView.setVisibility(show ? View.VISIBLE : View.GONE);
	    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
	}
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {
	@Override
	protected Boolean doInBackground(Void... params) {
	    // TODO: attempt authentication against a network service.

	    try {
		// Simulate network access.
		Thread.sleep(2000);
	    } catch (InterruptedException e) {
		return false;
	    }

	    // TODO: register the new account here.
	    return true;
	}

	@Override
	protected void onPostExecute(final Boolean success) {
	    mAuthTask = null;
	    showProgress(false);

	    if (success) {
		finish();
	    } else {
		mPasswordView
			.setError(getString(R.string.error_incorrect_password));
		mPasswordView.requestFocus();
	    }
	}

	@Override
	protected void onCancelled() {
	    mAuthTask = null;
	    showProgress(false);
	}
    }
}
