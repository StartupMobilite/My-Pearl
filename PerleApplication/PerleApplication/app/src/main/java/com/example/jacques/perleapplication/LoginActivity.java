package com.example.jacques.perleapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity implements AsyncResponse {

    Button btnLogin;
    Button btnRegisterScreen;
    EditText etUsername,etPassword;
    final String LOG="LoginActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);




        etUsername = (EditText)findViewById(R.id.etUsername);
        etPassword = (EditText)findViewById(R.id.etPassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap postData = new HashMap ();
                String Username = etUsername.getText().toString();
                String Password = etPassword.getText().toString();
                postData.put("txtUsername", Username);
                postData.put("txtPassword", Password );
                PostResponseAsyncTask loginTask = new PostResponseAsyncTask(LoginActivity.this, postData);
                loginTask.execute("http://maperle.esy.es/connection/login.php");
            }
        });

        btnRegisterScreen = (Button) findViewById(R.id.btnRegisterScreen);
        btnRegisterScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(i);

            }
        });


    }


    @Override
    public void processFinish(String s) {
        Log.d(LOG, s);
        if(s.contains("succes")){
            Toast.makeText(LoginActivity.this, getString(R.string.login_success),Toast.LENGTH_LONG).show();
            Intent in = new Intent(LoginActivity.this,NavigationDrawer
                    .class);
            startActivity(in);
        }
        else{
            Toast.makeText(LoginActivity.this, getString(R.string.login_error),Toast.LENGTH_LONG).show();
        }
        //Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
    }


}
