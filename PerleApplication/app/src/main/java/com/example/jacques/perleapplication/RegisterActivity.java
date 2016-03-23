package com.example.jacques.perleapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity implements AsyncResponse {

    Button btnregister;
    Button btnLinkToLoginScreen;
    EditText name,password,vpassword,email;

    String LOG="RegisterActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.password);
        vpassword = (EditText) findViewById(R.id.vpassword);
        email = (EditText) findViewById(R.id.email);
        btnregister = (Button) findViewById(R.id.btnRegister);
        btnLinkToLoginScreen = (Button) findViewById(R.id.btnLinkToLoginScreen);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap postData = new HashMap ();
                String Username = name.getText().toString();
                String Password = password.getText().toString();
                String vPassword = vpassword.getText().toString();
                String Email = email.getText().toString();
                postData.put("txtUsername", Username);
                postData.put("txtPassword", Password );
                postData.put("newPassword", vPassword );
                postData.put("mail", Email );
                PostResponseAsyncTask loginTask = new PostResponseAsyncTask(RegisterActivity.this, postData);
                loginTask.execute("http://maperle.esy.es/connection/register.php");
            }
        });

        btnLinkToLoginScreen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),
                        LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public void processFinish(String s) {

        Log.d(LOG, s);
        if(s.contains("succes")){
            Toast.makeText(RegisterActivity.this, "succes !", Toast.LENGTH_LONG).show();
            Intent in = new Intent(RegisterActivity.this,LoginActivity.class);
            startActivity(in);
        }
        else{
            Toast.makeText(RegisterActivity.this,"veillez renseigner tous les champs",Toast.LENGTH_LONG).show();
        }

    }
}
