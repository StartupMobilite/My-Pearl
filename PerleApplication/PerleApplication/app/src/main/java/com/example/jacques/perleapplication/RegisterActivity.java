package com.example.jacques.perleapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
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
    EditText username,password,surname,email,tel,school,firstName,fonction;

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

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.email);
        surname = (EditText) findViewById(R.id.surname);
        tel = (EditText) findViewById(R.id.tel);
        school = (EditText) findViewById(R.id.school);
        firstName = (EditText) findViewById(R.id.firstName);
        fonction = (EditText) findViewById(R.id.fonction);

        btnregister = (Button) findViewById(R.id.btnRegister);
        btnLinkToLoginScreen = (Button) findViewById(R.id.btnLinkToLoginScreen);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap postData = new HashMap ();
                String Username = username.getText().toString();
                String Password = password.getText().toString();
                String nom = surname.getText().toString();
                String FirstName = firstName.getText().toString();
                String Tel = tel.getText().toString();
                String School = school.getText().toString();
                String Email = email.getText().toString();
                String Fonction = fonction.getText().toString();
                postData.put("txtUsername", Username);
                postData.put("txtPassword", Password );
                postData.put("txtname", nom );
                postData.put("txtprenom", FirstName );
                postData.put("txtmail", Email );
                postData.put("txttel", Tel );
                postData.put("txtecole", School );
                postData.put("txtfonction", Fonction );
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
