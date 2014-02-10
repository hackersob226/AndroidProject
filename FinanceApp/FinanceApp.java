package com.hermes.financeapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private EditText  username = null;
	private EditText  password = null;
	private TextView attempts;
	private Button login, register, reset;
	int counter = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        username = (EditText)findViewById(R.id.editText1);
        password = (EditText)findViewById(R.id.editText2);
        attempts = (TextView)findViewById(R.id.textView5);
        attempts.setText(Integer.toString(counter));
        login = (Button)findViewById(R.id.button1);
        register = (Button)findViewById(R.id.button2);
        reset = (Button)findViewById(R.id.button3);
     
    
        register.setOnClickListener(new Button.OnClickListener(){
    		public void onClick(View v){
    		// TODO auto-generated method
    		
    		}
    	});
        reset.setOnClickListener(new Button.OnClickListener(){
     		public void onClick(View v){
     		// TODO auto-generated method
     		
     		}
     	});
    }
    
      

     public void login(View view){
        if(username.getText().toString().equals("admin") && 
        password.getText().toString().equals("admin")){
        Toast.makeText(getApplicationContext(), "Redirecting...", 
        Toast.LENGTH_SHORT).show();
     }	
     else{
        Toast.makeText(getApplicationContext(), "Wrong Password or Id",
        Toast.LENGTH_SHORT).show();
        attempts.setBackgroundColor(Color.RED);	
        counter--;
        attempts.setText(Integer.toString(counter));
        if(counter==0){
           login.setEnabled(false);
        }

     }

  }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
