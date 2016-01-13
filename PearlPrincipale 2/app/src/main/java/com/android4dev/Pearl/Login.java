package com.android4dev.Pearl;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends ActionBarActivity implements View.OnClickListener {

    Button bLogin;
    EditText etUsername,etPassword;
    TextView register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        etUsername = (EditText) findViewById(R.id.etusername);
        etPassword = (EditText) findViewById(R.id.etpassword);
        bLogin = (Button) findViewById(R.id.blogin);
        register = (TextView) findViewById(R.id.tvregister);


        bLogin.setOnClickListener(this);
        register.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.blogin:
                startActivity(new Intent(this,MainActivity.class));
                break;


            case R.id.tvregister:
                 startActivity(new Intent(this,Register.class));
                break;
        }
    }
}
