package com.example.jacques.perleapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

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
        MyView.setClass(this, LoginActivity.class);
        startActivity(MyView);
    }



}
