package com.example.jacques.perleapplication;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.daprlabs.cardstack.SwipeDeck;
import com.example.jacques.perleapplication.adapter.SwipeDeckAdapter;
import com.example.jacques.perleapplication.modele.AndroidVersion;

import java.util.ArrayList;

public class PicassoActivity extends AppCompatActivity {


    private final String android_version_names[] = {
            "test",
            "Ratp",
            "test3",
            "test1",
            "ratp2",
            "en",
            "calendrier"
    };

    private final String android_image_urls[] = {
            "http://www.maperle.esy.es/collections/uploads/0.png",
            "http://www.maperle.esy.es/collections/uploads/6.png",
            "http://www.maperle.esy.es/collections/uploads/5.png",
            "http://www.maperle.esy.es/collections/uploads/4.png",
            "http://www.maperle.esy.es/collections/uploads/7.png",
            "http://www.maperle.esy.es/collections/uploads/8.png",
            "http://www.maperle.esy.es/collections/uploads/9.png",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);

        // android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        initViews();
    }

    private void initViews(){
        ArrayList<AndroidVersion> androidVersions = prepareData();
        final SwipeDeck swipeDeck = (SwipeDeck) findViewById(R.id.swipe_deck);

        swipeDeck.setAdapter(new SwipeDeckAdapter(this, androidVersions));
        Button likeBt = (Button) findViewById(R.id.like_button);
        Button dislikeBt = (Button) findViewById(R.id.dislike_button);
        likeBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swipeDeck.swipeTopCardRight(300);
            }
        });
        dislikeBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swipeDeck.swipeTopCardLeft(300);
            }
        });
    }

    private ArrayList<AndroidVersion> prepareData(){

        ArrayList<AndroidVersion> android_version = new ArrayList<>();
        for(int i=0;i<android_version_names.length;i++){
            AndroidVersion androidVersion = new AndroidVersion();
            androidVersion.setAndroid_version_name(android_version_names[i]);
            androidVersion.setAndroid_image_url(android_image_urls[i]);
            android_version.add(androidVersion);
        }
        return android_version;
    }
}
