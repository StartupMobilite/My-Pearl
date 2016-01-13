package com.android4dev.Pearl;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.os.Handler;


import com.android4dev.Pearl.R;

import java.util.Timer;
import java.util.TimerTask;


public class Accueil extends ActionBarActivity  {

    private static final int TIME_TO_WAIT = 1 * 3000;
    TextView titre_accueil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        titre_accueil = (TextView) findViewById(R.id.titre_accueil);
        waitNext();

    }

    private void waitNext() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                next();
            }
        },TIME_TO_WAIT);
    }

    private void next(){
        //Toast toast = Toast.makeText(this, "First View!", 3000);
        Intent MyView = new Intent();
        MyView.setClass(this, Login.class);
        startActivity(MyView);
    }



}
