package com.android4dev.Pearl;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android4dev.Pearl.R;

public class Register extends ActionBarActivity implements View.OnClickListener {

    Button bRegesiter;
    EditText etName,etAge,etUsername,etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = (EditText) findViewById(R.id.etName);
        etUsername = (EditText) findViewById(R.id.etusername);
        etAge = (EditText) findViewById(R.id.etAge);
        etPassword = (EditText) findViewById(R.id.etpassword);

        bRegesiter = (Button) findViewById(R.id.bregister);

        bRegesiter.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bregister:
               startActivity(new Intent(this,Login.class));
                break;
        }
    }
}
